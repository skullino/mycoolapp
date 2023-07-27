package com.luv2code.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Pratice fast bowling for 15 minutes.";
    }
}
