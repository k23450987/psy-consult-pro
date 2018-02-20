package com.tom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tom.model.Quiz;
import com.tom.service.QuizService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quizs")
    public Map<String, Object> data(Integer page, Integer rows, String param) {
        Map<String, Object> result = new HashMap<>();
        try {
            Quiz quiz = JSON.parseObject(param, Quiz.class);
            PageHelper.startPage(page, rows);
            List<Quiz> quizs = quizService.findQuizs(quiz);
            PageInfo pageInfo = new PageInfo(quizs);
            result.put("datas", quizs);
            result.put("total", pageInfo.getTotal());
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/quizsWithTitle")
    public Map<String, Object> data(String param) {
        Map<String, Object> result = new HashMap<>();
        try {
            Quiz quiz = JSON.parseObject(param, Quiz.class);
            List<Quiz> quizs = quizService.findQuizs(quiz);
            StringBuilder sb = new StringBuilder();
            if (quizs.size() > 0) {
                for (Quiz obj : quizs) {
                    sb.append("<option value=\"")
                        .append(obj.getId())
                        .append("\">")
                        .append(obj.getId())
                        .append(".")
                        .append(obj.getTitle())
                        .append("</option>");
                }
            }
            result.put("datas", sb.toString());
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/quiz")
    public Map<String, Object> get(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", quizService.get(id));
            map.put("success", true);
        } catch (Exception e) {
            map.put("success", false);
            e.printStackTrace();
        }
        return map;
    }

    @PostMapping("/quiz")
    public Map<String, Object> add(Quiz quiz) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (quiz.getFlag()) {
                Quiz vo = new Quiz();
                vo.setFlag(true);
                List<Quiz> quizs = quizService.findQuizs(vo);
                if (quizs.size() > 0) {
                    map.put("success", false);
                    map.put("msg", "只能有一个第一题，当前的第一题编号为 " + quizs.get(0).getId());
                } else {
                    quizService.insert(quiz);
                    map.put("success", true);
                    map.put("id", quiz.getId());
                }
            } else {
                quizService.insert(quiz);
                map.put("success", true);
                map.put("id", quiz.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @PutMapping("/quiz")
    public Map<String, Object> update(Quiz quiz) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (quiz.getFlag()) {
                Quiz vo = new Quiz();
                vo.setFlag(true);
                List<Quiz> quizs = quizService.findQuizs(vo);
                if (quizs.size() > 0 && !Objects.equals(quizs.get(0).getId(), quiz.getId())) {
                    map.put("success", false);
                    map.put("msg", "只能有一个第一题，当前的第一题编号为 " + quizs.get(0).getId());
                } else {
                    quizService.updateSelective(quiz);
                    map.put("success", true);
                    map.put("id", quiz.getId());
                }
            } else {
                quizService.updateSelective(quiz);
                map.put("success", true);
                map.put("id", quiz.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @DeleteMapping("/quiz")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            quizService.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "删除失败，当前的问题已经被关联为某些问题的下一题。需要先解除关联，才能删除。");
        }
        return map;
    }
}
