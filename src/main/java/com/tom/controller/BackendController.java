package com.tom.controller;

import com.tom.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backend")
@Secured("ROLE_ADMIN")
public class BackendController {

    @Autowired
    private UserService userService;

    /**
     * 后台首页
     */
    @GetMapping("/index")
    public String index(Model model, Principal principal) {
        // 从 Spring Security 中获取到当前用户的 username，再转换为用户注册时的用户姓名
        model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        return "pages/backend/index";
    }

    /**
     * 用户管理
     */
    @GetMapping("/user")
    public String toUser(Model model, Principal principal) {
        model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        return "pages/backend/user";
    }

    /**
     * 文章管理
     */
    @GetMapping("/article")
    public String toArticle(Model model, Principal principal) {
        model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        return "pages/backend/article";
    }

    /**
     * 问题管理
     */
    @GetMapping("/question")
    public String toQuestion(Model model, Principal principal) {
        model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        return "pages/backend/question";
    }

    /**
     * 测评问题管理
     */
    @GetMapping("/psytest")
    public String toPsytest(Model model, Principal principal) {
        model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        return "pages/backend/psytest";
    }

}
