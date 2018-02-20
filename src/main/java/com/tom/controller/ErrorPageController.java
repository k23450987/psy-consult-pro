package com.tom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorPageController {

    @RequestMapping("/400")
    public String bad_request() {
        return "pages/error/400";
    }

    @RequestMapping("/403")
    public String forbidden() {
        return "pages/error/403";
    }

    @RequestMapping("/404")
    public String not_found() {
        return "pages/error/404";
    }

    @RequestMapping("/500")
    public String internal_server_error() {
        return "pages/error/500";
    }

    @RequestMapping("/503")
    public String service_unavailable() {
        return "pages/error/500";
    }
}
