package ru.kirilin.skillswap.mapper;

import org.mapstruct.Mapper;
import ru.kirilin.skillswap.dto.SkillDto;
import ru.kirilin.skillswap.entity.Skill;

@Mapper(componentModel = "Spring")
public interface SkillMapper {

    SkillDto toDto(Skill skill);
    Skill toEntity(SkillDto skill);
}
