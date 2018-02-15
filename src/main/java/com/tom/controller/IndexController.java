package com.tom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("hello", "hi tom");
        return "pages/index";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

}
