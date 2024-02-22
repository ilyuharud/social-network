package ru.otus.highloadarchitect.homework.socialnetwork.service;

import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.UserResponse;

import java.util.UUID;

public interface UserService {

    UserResponse getUserById(UUID userId);
}
