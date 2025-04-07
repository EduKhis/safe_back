package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.JwtException;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final JwtUtils jwtUtils;

    public User getUser(HttpServletRequest request) {

        String jwt = jwtUtils.parseJwt(request);
        if (jwt == null || !jwtUtils.validateJwtToken(jwt)) {
            throw new JwtException("Invalid JWT token");
        }
        String username = jwtUtils.getUserNameFromJwtToken(jwt);
        return userRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

}
