package ru.otus.highloadarchitect.homework.socialnetwork.service;

import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.LoginRequest;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.LoginResponse;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.RegisterRequest;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.RegisterResponse;

public interface AuthenticationService {
    LoginResponse login(LoginRequest loginRequest);
    RegisterResponse register(RegisterRequest registerRequest);
}
