package com.stratify.spring.files.excel.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file_metadata")
public class Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "size")
    private String size;

    @Column(name = "upload_date")
    private String uploadDate;

    @Column(name = "cells_area")
    private String area;


    public Metadata(String name, Date creationDate,
                    String size, String uploadDate, String area) {
        this.name = name;
        this.creationDate = creationDate;
        this.size = size;
        this.uploadDate = uploadDate;
        this.area = area;
    }

    public Metadata() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "ExcelMetadata{" +

                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", size='" + size + '\'' +
                ", uploadDate='" + uploadDate + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
