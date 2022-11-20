package ru.kirilin.skillswap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.kirilin.skillswap.entity.Gender;

import java.util.UUID;

public record UserDto(
        String login,
        String name,
        UUID logoId,
        Integer age,
        Gender gender) {
}
