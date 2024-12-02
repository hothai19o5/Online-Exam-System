package com.hothai.examsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.Result;
import com.hothai.examsystem.domain.entity.User;

public interface ResultRepository extends JpaRepository<Result, Integer>{
    public Result findOneById(long id);

    public Result findByUserAndExam(User user, Exam exam);
}
