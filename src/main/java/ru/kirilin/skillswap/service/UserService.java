package ru.kirilin.skillswap.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kirilin.skillswap.UserDto;
import ru.kirilin.skillswap.entity.AccountType;
import ru.kirilin.skillswap.entity.User;
import ru.kirilin.skillswap.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto getUserById(String id, AccountType accountType){
        return toDto(userRepository.findById(User.AccountId.of(id, accountType))
                .orElseThrow(() -> new IllegalArgumentException("User not found!")));
    }

    public UserDto createUser(User user){
        return toDto(userRepository.save(user));
    }

    private UserDto toDto(User user){
        return new UserDto(user.getLogin(),
                user.getName(), user.getLogo(), user.getAge(),
                user.getGender());
    }
}
