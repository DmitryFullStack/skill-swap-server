package ru.kirilin.skillswap;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.kirilin.skillswap.entity.Gender;

public record UserDto(
        String login,
        String name,
        String logo,
        Integer age,
        Gender gender) {
}
