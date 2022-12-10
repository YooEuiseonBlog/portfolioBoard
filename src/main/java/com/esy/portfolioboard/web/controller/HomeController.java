package com.esy.portfolioboard.web.controller;

import com.esy.portfolioboard.domain.entity.QHello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "/";
    }
}
