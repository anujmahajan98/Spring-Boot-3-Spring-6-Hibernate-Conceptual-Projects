package com.springcode.springcoredemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{

    public BasketballCoach(){
        System.out.println("In Constructor - " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Dribbling";
    }
}
