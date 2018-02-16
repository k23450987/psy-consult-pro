package com.tom.controller;

import java.security.Principal;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CommonsLog
public class IndexController {

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "pages/index";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

}
