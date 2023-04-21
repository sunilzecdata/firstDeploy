package com.example.demo.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.JobPost;

public interface JobPostDao extends JpaRepository<JobPost, UUID> {

}
