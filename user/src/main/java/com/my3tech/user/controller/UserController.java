package com.my3tech.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my3tech.user.dto.UserDTO;
import com.my3tech.user.security.AuthenticationRequest;
import com.my3tech.user.security.RegistrationRequest;
import com.my3tech.user.service.IUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest authRequest) {
        userService.loginUser(authRequest);
        return ResponseEntity.ok("Welcome " + authRequest.getEmail());
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegistrationRequest req) {
        return ResponseEntity.ok(userService.registerUser(req));
    }

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getUser(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUser(email));
    }
}
