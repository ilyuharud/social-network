package ru.otus.highloadarchitect.homework.socialnetwork.mapper;

import org.springframework.stereotype.Component;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.RegisterResponse;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.UserResponse;
import ru.otus.highloadarchitect.homework.socialnetwork.model.entity.User;

import java.time.LocalDate;

@Component
public class ResponseMapper {
    public RegisterResponse toRegisterResponse(User user) {
        return new RegisterResponse(user.getId());
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                LocalDate.parse(user.getBirthdate().toString()),
                user.getGender(),
                user.getInterests(),
                user.getCity());
    }
}
