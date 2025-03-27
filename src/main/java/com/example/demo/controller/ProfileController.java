package com.example.demo.controller;

import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "${cors.origins}")
@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getProfile(@RequestHeader(name = "X-Access-Token") String jwt) {
        System.out.println(jwt);
        return new ResponseEntity<>(userService.findUser(jwt), HttpStatus.OK);
    }
}
