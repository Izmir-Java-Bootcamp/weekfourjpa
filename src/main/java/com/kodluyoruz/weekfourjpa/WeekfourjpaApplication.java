package com.kodluyoruz.weekfourjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class WeekfourjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeekfourjpaApplication.class, args);
    }

}
