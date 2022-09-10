package ru.kirilin.skillswap.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.kirilin.skillswap.entity.Skill;
import ru.kirilin.skillswap.entity.User;

import java.util.UUID;

public interface SkillRepository extends PagingAndSortingRepository<Skill, UUID> {
}
