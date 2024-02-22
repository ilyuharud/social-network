package ru.otus.highloadarchitect.homework.socialnetwork.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.LoginRequest;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.LoginResponse;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.RegisterRequest;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.RegisterResponse;
import ru.otus.highloadarchitect.homework.socialnetwork.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        return authenticationService.register(registerRequest);
    }
}
