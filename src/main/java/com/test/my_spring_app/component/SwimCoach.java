package com.test.my_spring_app.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SwimCoach implements Coach{
    public SwimCoach() {
        System.out.println("SwimCoach Constructor");
    }
    @PostConstruct
    public void post(){
        System.out.println("SwimCoach post Construct");
    }
    @PreDestroy
    public void pre(){
        System.out.println("SwimCoach pre Destory");
    }
    @Override
    public String getDailyWorkout() {
        return "practice swiming for 1hr daily";
    }
}
