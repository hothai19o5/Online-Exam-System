package com.hothai.examsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hothai.examsystem.domain.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer> {
    public Batch findOneById(int id);
    public void deleteById(int id);
}
