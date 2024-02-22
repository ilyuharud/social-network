package ru.otus.highloadarchitect.homework.socialnetwork.component.impl;

import org.springframework.stereotype.Component;
import ru.otus.highloadarchitect.homework.socialnetwork.component.IdGenerator;

import java.util.UUID;

@Component
public class IdGeneratorImpl implements IdGenerator {
    @Override
    public UUID generateUUID() {
        return UUID.randomUUID();
    }
}
