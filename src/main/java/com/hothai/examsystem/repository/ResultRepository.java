package com.hothai.examsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hothai.examsystem.domain.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer>{
    public Result findOneById(long id);

}
