package ru.otus.highloadarchitect.homework.socialnetwork.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.otus.highloadarchitect.homework.socialnetwork.model.entity.Role;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("second_name")
        private String secondName;
        private LocalDate birthdate;
        private String gender;
        private String interests;
        private String city;
        @ToString.Exclude
        private String password;
        private Role role;
}
