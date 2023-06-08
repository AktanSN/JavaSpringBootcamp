package com.aktansanhal.weatherfinalcase;

import com.aktansanhal.weatherfinalcase.entity.User;
import com.aktansanhal.weatherfinalcase.service.concretes.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class WeatherAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitialUser(UserServiceImpl userServiceImpl) {
        return (args) -> {
            User user = new User();
            user.setUsername("aktansn");

            user.setPassword("P4ssword.");
            userServiceImpl.save(user);
        };
    }

}
