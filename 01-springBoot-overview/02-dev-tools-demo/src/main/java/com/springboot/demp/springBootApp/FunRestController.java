package com.springboot.demp.springBootApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String syaHello(){
        return "Hello World";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 10 Km";
    }
}
