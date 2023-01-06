package ru.kirilin.skillswap.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kirilin.skillswap.dto.UserDto;
import ru.kirilin.skillswap.entity.AccountType;
import ru.kirilin.skillswap.entity.User;
import ru.kirilin.skillswap.mapper.UserMapper;
import ru.kirilin.skillswap.repository.FileRepository;
import ru.kirilin.skillswap.repository.UserRepository;

import static java.util.Objects.nonNull;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FileRepository fileRepository;
    private final UserMapper userMapper;

    public UserDto getUserById(String id, AccountType accountType) {
        return toDto(userRepository.findById(User.AccountId.of(id, accountType))
                .orElseThrow(() -> new IllegalArgumentException("User not found!")));
    }

    public UserDto createUser(User user) {
        return toDto(userRepository.save(user));
    }

    public UserDto updateUser(UserDto user) {
        User storedUser = userRepository.findById(user.id())
                .orElseThrow();
        if (nonNull(storedUser.getLogoId()) && storedUser.getLogoId() != user.logoId()) {
            if (fileRepository.existsById(storedUser.getLogoId())) {
                fileRepository.deleteById(storedUser.getLogoId());
            }
        }
        toEntity(user, storedUser);
        return userMapper.toDto(userRepository.save(storedUser));
    }

    private UserDto toDto(User user) {
        return new UserDto(user.getId(),
                user.getLogin(),
                user.getName(), user.getLogoId(), user.getAge(),
                user.getGender());
    }

    private User toEntity(UserDto userDto, User user) {
        return user.setName(userDto.name())
                .setLogin(userDto.login())
                .setLogoId(userDto.logoId())
                .setAge(userDto.age())
                .setGender(userDto.gender());
    }
}
