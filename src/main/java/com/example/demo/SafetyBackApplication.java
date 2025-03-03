package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SafetyBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafetyBackApplication.class, args);
    }

}
