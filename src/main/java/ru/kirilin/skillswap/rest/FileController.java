package ru.kirilin.skillswap.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.kirilin.skillswap.entity.AppFile;
import ru.kirilin.skillswap.service.FileService;

import java.util.UUID;

@RestController
@RequestMapping("/v1/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<UUID> saveNewFile(@RequestBody MultipartFile file){
        return ResponseEntity.ok(fileService.saveNewFile(file));
    }

    @PostMapping("/{appFile}")
    public ResponseEntity<byte[]> getFile(@PathVariable AppFile appFile){
        return ResponseEntity.ok(appFile.getData());
    }
}
