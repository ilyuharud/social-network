package ru.otus.highloadarchitect.homework.socialnetwork.dao;

import ru.otus.highloadarchitect.homework.socialnetwork.model.entity.User;

import java.util.Optional;

public interface UserDao {

    User save(User user);
    Optional<User> findById(String userId);
}
