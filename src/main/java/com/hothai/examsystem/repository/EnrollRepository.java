package com.hothai.examsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.Enroll;

public interface EnrollRepository extends JpaRepository<Enroll, Integer> {
    public List<Enroll> findByBatch(Batch batch);
}
