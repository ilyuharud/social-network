package ru.otus.highloadarchitect.homework.socialnetwork.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record RegisterResponse(@JsonProperty("user_id") UUID userId) {
}
