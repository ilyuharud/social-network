package ru.otus.highloadarchitect.homework.socialnetwork.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.otus.highloadarchitect.homework.socialnetwork.component.IdGenerator;
import ru.otus.highloadarchitect.homework.socialnetwork.dao.UserDao;
import ru.otus.highloadarchitect.homework.socialnetwork.model.entity.Role;
import ru.otus.highloadarchitect.homework.socialnetwork.model.entity.User;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final IdGenerator idGenerator;

    @Override
    public User save(User user) {
        var userId = idGenerator.generateUUID();
        var sql = "INSERT INTO users (id, first_name, second_name, birthdate, gender, interests, city, password, role) " +
                "VALUES (:id, :first_name, :second_name, :birthdate, :gender, :interests, :city, :password, :role)";
        var params = new MapSqlParameterSource()
                .addValue("id", userId.toString())
                .addValue("first_name", user.getFirstName())
                .addValue("second_name", user.getSecondName())
                .addValue("birthdate", user.getBirthdate())
                .addValue("gender", user.getGender())
                .addValue("interests", user.getInterests())
                .addValue("city", user.getCity())
                .addValue("password", user.getPassword())
                .addValue("role", user.getRole().name());
        var ignored = namedParameterJdbcTemplate.update(sql, params);
        user.setId(userId);
        return user;
    }

    @Override
    public Optional<User> findById(String userId) {
        var sql = "SELECT * FROM users WHERE id = :id";
        var params = new MapSqlParameterSource()
                .addValue("id", userId);
        var user = namedParameterJdbcTemplate.queryForObject(sql, params, (rs, rowNum) ->
                new User(
                        UUID.fromString(rs.getString("id")),
                        rs.getString("first_name"),
                        rs.getString("second_name"),
                        rs.getDate("birthdate"),
                        rs.getString("gender"),
                        rs.getString("interests"),
                        rs.getString("city"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role"))
                ));
        return Optional.ofNullable(user);
    }
}
