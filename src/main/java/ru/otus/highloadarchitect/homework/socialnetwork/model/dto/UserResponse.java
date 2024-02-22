package ru.otus.highloadarchitect.homework.socialnetwork.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.UUID;

public record UserResponse(
        UUID id,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("second_name")
        String secondName,
        LocalDate birthdate,
        String gender,
        String interests,
        String city
) {
}
