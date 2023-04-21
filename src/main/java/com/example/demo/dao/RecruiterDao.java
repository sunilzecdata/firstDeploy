package com.example.demo.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Recruiter;

public interface RecruiterDao extends JpaRepository<Recruiter, UUID>{

}
