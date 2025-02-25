package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SafetyBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafetyBackApplication.class, args);

        Map<String, String> properties = new HashMap<>();
        properties.put("server", "8080");
        properties.put("serveri", "8080");

        Map<String, String> properties2 = new HashMap<>();
        properties2.put("server4", "8082");

        properties.putAll(properties2);

        System.out.println(properties);
    }

}
