package com.lyzstack.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcome() {
        System.out.println("WelcomeController.welcome 触发了！");
        // 明确指向static目录下的login.html
        return "forward:/login.html";
    }
}