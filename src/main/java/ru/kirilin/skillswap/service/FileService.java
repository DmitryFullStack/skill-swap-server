package ru.kirilin.skillswap.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.kirilin.skillswap.entity.AppFile;
import ru.kirilin.skillswap.entity.FileType;
import ru.kirilin.skillswap.repository.FileRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    @SneakyThrows
    public UUID saveNewFile(MultipartFile file) {
        return fileRepository.save(new AppFile()
                .setData(file.getBytes())
                .setFileType(FileType.IMAGE))
                .getId();
    }

}
