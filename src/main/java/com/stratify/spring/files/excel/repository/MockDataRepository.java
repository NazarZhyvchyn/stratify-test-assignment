package com.stratify.spring.files.excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stratify.spring.files.excel.model.MockData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MockDataRepository extends JpaRepository<MockData, Long>, JpaSpecificationExecutor<MockData> {
}


