package ru.otus.highloadarchitect.homework.socialnetwork.service;

import io.jsonwebtoken.Claims;
import ru.otus.highloadarchitect.homework.socialnetwork.model.entity.User;

import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    String extractUserId(String token);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    String generateToken(Map<String, Object> extraClaims, User user);
    String generateToken(User user);
    boolean isTokenValid(String token, User user);
}
