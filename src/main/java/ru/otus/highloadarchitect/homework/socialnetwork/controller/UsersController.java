package ru.otus.highloadarchitect.homework.socialnetwork.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.*;
import ru.otus.highloadarchitect.homework.socialnetwork.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {


    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable UUID userId) {
        return userService.getUserById(userId);
    }
}
