package com.stratify.spring.files.excel.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stratify.spring.files.excel.helper.ExcelHelper;
import com.stratify.spring.files.excel.model.MockData;
import com.stratify.spring.files.excel.repository.MockDataRepository;

@Service
public class MockDataService {

    @Autowired
    MockDataRepository repository;

    public void save(MultipartFile file) {
      try {
        List<MockData> mockData = ExcelHelper.excelToData(file.getInputStream());

          repository.saveAll(mockData);
      } catch (IOException e) {
        throw new RuntimeException("fail to store excel data: " + e.getMessage());
      }
    }


  public List<MockData> getAllMockdata() {
    return repository.findAll();
  }
}
