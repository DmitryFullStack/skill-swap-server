package ru.kirilin.skillswap.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.kirilin.skillswap.entity.Skill;

import java.util.UUID;

public interface SkillRepository extends PagingAndSortingRepository<Skill, UUID> {

    @Modifying
    @Query("update Skill s set s.archive = true where s.id = :id")
    int setSkillArchiveTrue(@Param("id") UUID id);

    @Modifying
    @Query("update Skill s set s.archive = false where s.id = :id")
    int recoverSkill(@Param("id") UUID id);
}
