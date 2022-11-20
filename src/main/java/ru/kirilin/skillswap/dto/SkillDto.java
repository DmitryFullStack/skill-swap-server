package ru.kirilin.skillswap.dto;

import ru.kirilin.skillswap.entity.Level;

import java.math.BigDecimal;
import java.util.UUID;

public record SkillDto(
        UUID id,
        String name,
        Level level,
        BigDecimal price,

        Integer experience
        ) {
}
