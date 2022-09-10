package ru.kirilin.skillswap.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.kirilin.skillswap.entity.User;

import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
