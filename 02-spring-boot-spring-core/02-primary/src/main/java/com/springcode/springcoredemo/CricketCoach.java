package com.springcode.springcoredemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Primary
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice Batting for at least an hour";
    }
}
