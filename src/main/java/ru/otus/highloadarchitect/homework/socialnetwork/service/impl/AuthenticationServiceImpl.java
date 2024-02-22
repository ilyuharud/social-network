package ru.otus.highloadarchitect.homework.socialnetwork.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.otus.highloadarchitect.homework.socialnetwork.dao.UserDao;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.LoginRequest;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.LoginResponse;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.RegisterRequest;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.RegisterResponse;
import ru.otus.highloadarchitect.homework.socialnetwork.mapper.RequestMapper;
import ru.otus.highloadarchitect.homework.socialnetwork.mapper.ResponseMapper;
import ru.otus.highloadarchitect.homework.socialnetwork.service.AuthenticationService;
import ru.otus.highloadarchitect.homework.socialnetwork.service.JwtService;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;
    private final UserDao userDao;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        log.info("Login user: {}", loginRequest.userId());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.userId(), loginRequest.password())
        );
        var user = userDao.findById(loginRequest.userId())
                .orElseThrow();
        var token = jwtService.generateToken(user);
        return new LoginResponse(token);
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        log.info("Register new user, with params: {}", registerRequest);
        var userEntity = requestMapper.toUserEntity(registerRequest);
        var createdUser = userDao.save(userEntity);
        return responseMapper.toRegisterResponse(createdUser);
    }
}
