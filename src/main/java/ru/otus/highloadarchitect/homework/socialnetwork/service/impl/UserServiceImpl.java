package ru.otus.highloadarchitect.homework.socialnetwork.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.highloadarchitect.homework.socialnetwork.dao.UserDao;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.UserResponse;
import ru.otus.highloadarchitect.homework.socialnetwork.mapper.ResponseMapper;
import ru.otus.highloadarchitect.homework.socialnetwork.service.UserService;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final ResponseMapper responseMapper;

    @Override
    public UserResponse getUserById(UUID userId) {
        log.info("Get user by id: {}", userId);
        var userEntity = userDao.findById(userId.toString()).orElseThrow();
        return responseMapper.toUserResponse(userEntity);
    }
}
