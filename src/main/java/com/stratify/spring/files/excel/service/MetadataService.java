package com.stratify.spring.files.excel.service;

import com.stratify.spring.files.excel.helper.ExcelHelper;
import com.stratify.spring.files.excel.model.Metadata;
import com.stratify.spring.files.excel.repository.MetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class MetadataService {

    @Autowired
    MetadataRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Metadata> metadata = ExcelHelper.metadataToData(file.getInputStream());
            repository.saveAll(metadata);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}
