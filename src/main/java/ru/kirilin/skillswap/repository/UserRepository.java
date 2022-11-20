package ru.kirilin.skillswap.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.kirilin.skillswap.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, User.AccountId> {
}
