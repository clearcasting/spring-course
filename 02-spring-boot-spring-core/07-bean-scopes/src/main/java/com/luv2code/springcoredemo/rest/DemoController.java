package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    @Qualifier("cricketCoach")
    public void DemoController(Coach myCoach, Coach anotherCoach) {
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
        System.out.println("In Constructor " + getClass().getSimpleName());
    }

    @GetMapping("/check")
    public String checkScope() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
