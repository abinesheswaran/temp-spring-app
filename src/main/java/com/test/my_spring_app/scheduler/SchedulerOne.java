package com.test.my_spring_app.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulerOne {
    @Scheduled(fixedRate = 60000)
    public void runnables() {
        System.out.println("[S1] Scheduler is running...");
    }
}
