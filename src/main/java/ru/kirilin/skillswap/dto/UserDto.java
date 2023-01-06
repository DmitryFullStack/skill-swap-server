package ru.kirilin.skillswap.dto;

import ru.kirilin.skillswap.entity.Gender;
import ru.kirilin.skillswap.entity.User;

import java.util.UUID;

public record UserDto(

        User.AccountId id,
        String login,
        String name,
        UUID logoId,
        Integer age,
        Gender gender) {
}
