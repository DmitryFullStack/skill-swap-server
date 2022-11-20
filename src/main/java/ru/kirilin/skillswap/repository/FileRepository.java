package ru.kirilin.skillswap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirilin.skillswap.entity.AppFile;

import java.util.UUID;

public interface FileRepository extends JpaRepository<AppFile, UUID> {
}
