package com.springboot.demp.springBootApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach - " + coachName + " , Team - " + teamName;
    }

    @GetMapping("/")
    public String syaHello(){
        return "Hello World";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 10 Km";
    }
}
