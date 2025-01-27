package com.test.my_spring_app.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FoodballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "run 10km daily for 30days";
    }
}
