package ru.otus.highloadarchitect.homework.socialnetwork.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.otus.highloadarchitect.homework.socialnetwork.model.dto.RegisterRequest;
import ru.otus.highloadarchitect.homework.socialnetwork.model.entity.User;

import java.sql.Date;

@Component
@RequiredArgsConstructor
public class RequestMapper {

    private final PasswordEncoder passwordEncoder;

    public User toUserEntity(RegisterRequest registerRequest) {
        return new User(
                null,
                registerRequest.getFirstName(),
                registerRequest.getSecondName(),
                Date.valueOf(registerRequest.getBirthdate().toString()),
                registerRequest.getGender(),
                registerRequest.getInterests(),
                registerRequest.getCity(),
                passwordEncoder.encode(registerRequest.getPassword()),
                registerRequest.getRole()
        );
    }
}
