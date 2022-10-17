package ru.kirilin.skillswap.mapper;

import org.mapstruct.Mapper;
import ru.kirilin.skillswap.dto.RequirementDto;
import ru.kirilin.skillswap.entity.Requirement;

@Mapper(componentModel = "Spring")
public interface RequirementMapper {

    RequirementDto toDto(Requirement skill);
    Requirement toEntity(RequirementDto skill);
}
