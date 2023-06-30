package com.springdemo.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String syaHello(Model theModel){
        theModel.addAttribute("Date", new java.util.Date());
        return "helloWorld";
    }
}
