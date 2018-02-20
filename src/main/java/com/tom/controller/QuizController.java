package com.tom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tom.model.Quiz;
import com.tom.service.QuizService;
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

    /**
     * 这个方法会将所有的问题拼接成 &lt;option&gt;
     * 以便于在编辑问题选项时选择要跳转的问题
     */
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
                        .append(obj.getId())    // 问题编号
                        .append(".")
                        .append(obj.getTitle()) // 问题标题
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
                // 当前操作要将这一题作为第一题展示
                Quiz vo = new Quiz();
                vo.setFlag(true);
                List<Quiz> quizs = quizService.findQuizs(vo);
                // 判断是否已经存在第一题了
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
            // 当前操作要将这一题作为第一题展示
            if (quiz.getFlag()) {
                Quiz vo = new Quiz();
                vo.setFlag(true);
                List<Quiz> quizs = quizService.findQuizs(vo);
                // 判断是否已经存在第一题了，或者当前题目就是第一题
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
