package ru.kirilin.skillswap.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.kirilin.skillswap.entity.Requirement;
import ru.kirilin.skillswap.entity.Skill;

import java.util.UUID;

public interface RequirementRepository extends PagingAndSortingRepository<Requirement, UUID> {
}
