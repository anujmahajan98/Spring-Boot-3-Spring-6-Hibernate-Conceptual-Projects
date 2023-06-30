package com.springcode.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice Dribbling";
    }
}
