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

    @GetMapping("/index")
    public String index(Model model, Principal principal) {
        model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        return "pages/backend/index";
    }

    @GetMapping("/user")
    public String toUser(Model model, Principal principal) {
        model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        return "pages/backend/user";
    }

    @GetMapping("/article")
    public String toArticle(Model model, Principal principal) {
        model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        return "pages/backend/article";
    }

    @GetMapping("/question")
    public String toQuestion(Model model, Principal principal) {
        model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        return "pages/backend/question";
    }

    @GetMapping("/psytest")
    public String toPsytest(Model model, Principal principal) {
        model.addAttribute("username", userService.findByUsername(principal.getName()).getName());
        return "pages/backend/psytest";
    }

}
