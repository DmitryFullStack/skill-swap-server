package ru.kirilin.skillswap.mapper;

import org.mapstruct.Mapper;
import ru.kirilin.skillswap.dto.UserDto;
import ru.kirilin.skillswap.entity.User;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto user);
}
