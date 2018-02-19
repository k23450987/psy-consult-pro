package com.tom.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tom.model.Article;
import com.tom.service.ArticleService;
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
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public Map<String, Object> data(Integer page, Integer rows, String param) {
        Map<String, Object> result = new HashMap<>();
        try {
            PageHelper.startPage(page, rows);
            List<Article> articles = articleService.findArticles();
            PageInfo pageInfo = new PageInfo(articles);
            result.put("datas", articles);
            result.put("total", pageInfo.getTotal());
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/article")
    public Map<String, Object> get(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", articleService.get(id));
            map.put("success", true);
        } catch (Exception e) {
            map.put("success", false);
            e.printStackTrace();
        }
        return map;
    }

    @PostMapping("/article")
    public Map<String, Object> add(Article article) {
        Map<String, Object> map = new HashMap<>();
        try {
            articleService.insert(article);
            map.put("success", true);
            map.put("id", article.getId());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @PutMapping("/article")
    public Map<String, Object> update(Article article) {
        Map<String, Object> map = new HashMap<>();
        try {
            articleService.updateSelective(article);
            map.put("success", true);
            map.put("id", article.getId());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @DeleteMapping("/article")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            articleService.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }
}
