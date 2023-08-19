package com.springboot.File.service;

import com.springboot.File.model.FileDB;
import com.springboot.File.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileService {
    @Autowired
    FileRepository fileRepository;

    public FileDB storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB fileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
        return fileRepository.save(fileDB);
    }
    public FileDB getFile(String id) {
        return fileRepository.findById(id).get();
    }
    public Stream<FileDB> getAllFiles() {
        return fileRepository.findAll().stream();
    }
}
