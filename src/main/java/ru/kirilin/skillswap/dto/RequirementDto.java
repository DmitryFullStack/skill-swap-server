package ru.kirilin.skillswap.dto;

import ru.kirilin.skillswap.entity.Level;

import java.math.BigDecimal;
import java.util.UUID;

public record RequirementDto(
        UUID id,
        String name,
        String description,
        String gender,
        Integer minExperience) {
}
