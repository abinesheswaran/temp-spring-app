package com.test.my_spring_app.config;

import com.test.my_spring_app.component.Coach;
import com.test.my_spring_app.component.CricketCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CricketCoachConfig {
    @Bean
    public Coach cricketCoach(){
        System.out.println("Creating Cricket Coach Bean");
        return new CricketCoach();
    }
}
