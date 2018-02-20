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

/**
 * 写在前面 <br/><br/>
 * 实体类对应的 Controller 都采用了类似 RESTful 设计风格进行了设计，
 * 基于这个风格设计的是为了代码上更简洁，更有层次。每个资源都使用唯一的地址。所有资源都共享统一的接口。 <br/><br/>
 * 为了适应这种风格，页面上统一使用 jQuery 的 $.ajax 来支持 GET, POST, PUT, DELETE 这几种请求方式
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public Map<String, Object> data(Integer page, Integer rows, String param) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 进行分页查询
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
