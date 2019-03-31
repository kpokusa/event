package com.eventcalendar.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {"com.eventcalendar.event.configuration", "com.eventcalendar.event.controller", "com.eventcalendar.event.exceptions", "com.eventcalendar.event.persistance", "com.eventcalendar.event.service"})
@EnableJpaRepositories
public class EventApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class, args);
    }

}
