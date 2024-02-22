package ru.otus.highloadarchitect.homework.socialnetwork.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginRequest(@JsonProperty("user_id") String userId, String password) {
}
