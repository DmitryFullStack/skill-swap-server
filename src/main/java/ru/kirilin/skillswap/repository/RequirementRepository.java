package ru.kirilin.skillswap.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.kirilin.skillswap.entity.Requirement;

import java.util.UUID;


public interface RequirementRepository extends PagingAndSortingRepository<Requirement, UUID> {
}
