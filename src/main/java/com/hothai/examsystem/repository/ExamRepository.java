package com.hothai.examsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hothai.examsystem.domain.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{
    public Exam findOneById(long id);
}
