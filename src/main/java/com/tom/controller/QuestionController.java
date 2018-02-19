package com.tom.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tom.model.Question;
import com.tom.service.QuestionService;
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
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public Map<String, Object> data(Integer page, Integer rows, String param) {
        Map<String, Object> result = new HashMap<>();
        try {
            PageHelper.startPage(page, rows);
            List<Question> questions = questionService.findQuestions();
            PageInfo pageInfo = new PageInfo(questions);
            result.put("datas", questions);
            result.put("total", pageInfo.getTotal());
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/question")
    public Map<String, Object> get(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", questionService.get(id));
            map.put("success", true);
        } catch (Exception e) {
            map.put("success", false);
            e.printStackTrace();
        }
        return map;
    }

    @PostMapping("/question")
    public Map<String, Object> add(Question question) {
        Map<String, Object> map = new HashMap<>();
        try {
            questionService.insert(question);
            map.put("success", true);
            map.put("id", question.getId());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @PutMapping("/question")
    public Map<String, Object> update(Question question) {
        Map<String, Object> map = new HashMap<>();
        try {
            questionService.updateSelective(question);
            map.put("success", true);
            map.put("id", question.getId());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @DeleteMapping("/question")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            questionService.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }
}
