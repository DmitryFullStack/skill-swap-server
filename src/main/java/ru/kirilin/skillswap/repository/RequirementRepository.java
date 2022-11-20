package ru.kirilin.skillswap.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.kirilin.skillswap.entity.Requirement;
import ru.kirilin.skillswap.entity.Skill;

import java.util.UUID;

public interface RequirementRepository extends PagingAndSortingRepository<Requirement, UUID> {
    @Modifying
    @Query("update Requirement r set r.archive = true where r.id = :id")
    int setRequirementArchiveTrue(@Param("id") UUID id);

    @Modifying
    @Query("update Requirement r set r.archive = false where r.id = :id")
    int recoverRequirement(@Param("id") UUID id);
}
