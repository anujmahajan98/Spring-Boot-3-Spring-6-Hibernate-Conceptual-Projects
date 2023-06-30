package com.springcode.springcoredemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("basketballCoach") Coach theCoach){
        System.out.println("In Constructor - " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("After Bean Construction");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Before Bean Destruction");
    }
}
