package com.stratify.spring.files.excel.repository;

import com.stratify.spring.files.excel.model.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepository extends JpaRepository<Metadata, Long> {
}
