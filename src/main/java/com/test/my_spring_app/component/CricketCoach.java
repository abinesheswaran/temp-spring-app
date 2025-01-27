package com.test.my_spring_app.component;

public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("CricketCoach Constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "practice cricket daily for 1hr";
    }
}
