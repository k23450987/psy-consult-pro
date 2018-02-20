package com.tom.controller;

import com.tom.model.Option;
import com.tom.service.OptionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptionController {

    @Autowired
    private OptionService optionService;

    @GetMapping("/options")
    public Map<String, Object> data(Option option) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Option> options = optionService.findOptions(option);
            result.put("datas", options);
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/findOptionsByQuizId")
    public Map<String, Object> data(Integer quizId) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Option> options = optionService.findOptionsByQuizId(quizId);
            result.put("datas", options);
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/option")
    public Map<String, Object> get(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", optionService.get(id));
            map.put("success", true);
        } catch (Exception e) {
            map.put("success", false);
            e.printStackTrace();
        }
        return map;
    }

    @PostMapping("/option")
    public Map<String, Object> add(Option option) {
        Map<String, Object> map = new HashMap<>();
        try {
            Option vo = new Option();
            vo.setQuizId(option.getQuizId());
            List<Option> options = optionService.findOptions(vo);
            if (options.size() >= 4) {
                map.put("success", false);
                map.put("msg", "一个问题最多只能拥有4个选项，请在选项管理中删除多余选项。");
            } else {
                optionService.insert(option);
                map.put("success", true);
                map.put("id", option.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @PutMapping("/option")
    public Map<String, Object> update(Option option) {
        Map<String, Object> map = new HashMap<>();
        try {
            optionService.updateSelective(option);
            map.put("success", true);
            map.put("id", option.getId());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @DeleteMapping("/option")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            optionService.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }
}
