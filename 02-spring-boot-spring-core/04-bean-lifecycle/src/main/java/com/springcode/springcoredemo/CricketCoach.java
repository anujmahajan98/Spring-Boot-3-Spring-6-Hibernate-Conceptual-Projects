package com.springcode.springcoredemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In Constructor - " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Batting for at least an hour";
    }
}
