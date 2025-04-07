package com.example.demo.controller;

import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<?> getProfile(HttpServletRequest request) {
        System.out.println(request);
        return new ResponseEntity<>(userService.getUser(request), HttpStatus.OK);
    }
}
