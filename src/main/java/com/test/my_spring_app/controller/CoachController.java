package com.test.my_spring_app.controller;

import com.test.my_spring_app.component.Coach;
import com.test.my_spring_app.component.CricketCoach;
import com.test.my_spring_app.component.SwimCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coach")
public class CoachController {

    private Coach coach;
    private Coach cricketCoach;
    @Autowired
    @Lazy
    private SwimCoach swimCoach;

    @Autowired
    public CoachController(Coach coach) {
        this.coach = coach;
    }

    @Autowired
    public void setCoach(@Qualifier("cricketCoach") Coach coach) {
        this.cricketCoach = coach;
    }

    @GetMapping("/getWorkout")
    public String getWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/getCricketPractice")
    public String getCricketPractice() {
        return cricketCoach.getDailyWorkout();
    }

    @GetMapping("/getSwimingPractice")
    public String getSwimingPractice() {
        return swimCoach.getDailyWorkout();
    }
}
