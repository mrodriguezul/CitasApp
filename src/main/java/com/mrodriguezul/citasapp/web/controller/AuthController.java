package com.mrodriguezul.citasapp.web.controller;

import com.mrodriguezul.citasapp.domain.model.User;
import com.mrodriguezul.citasapp.domain.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserSecurityService userSecurityService;

    @Autowired
    public AuthController(UserSecurityService userSecurityService) {
        this.userSecurityService = userSecurityService;
    }

    @RequestMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String token = userSecurityService.loginUser(user);

        System.out.println("Generated Token: " + token);
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).body("Login successful");
    }
}
