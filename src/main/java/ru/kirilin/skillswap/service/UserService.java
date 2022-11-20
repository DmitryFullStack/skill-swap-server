package ru.kirilin.skillswap.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kirilin.skillswap.dto.UserDto;
import ru.kirilin.skillswap.entity.AccountType;
import ru.kirilin.skillswap.entity.User;
import ru.kirilin.skillswap.mapper.UserMapper;
import ru.kirilin.skillswap.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto getUserById(String id, AccountType accountType){
        return toDto(userRepository.findById(User.AccountId.of(id, accountType))
                .orElseThrow(() -> new IllegalArgumentException("User not found!")));
    }

    public UserDto createUser(User user){
        return toDto(userRepository.save(user));
    }

    private UserDto toDto(User user){
        return new UserDto(user.getLogin(),
                user.getName(), user.getLogoId(), user.getAge(),
                user.getGender());
    }

    public UserDto updateUser(User user) {
        return userMapper.toDto(userRepository.save(user));
    }
}
