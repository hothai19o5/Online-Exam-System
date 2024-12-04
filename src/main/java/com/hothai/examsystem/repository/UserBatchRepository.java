package com.hothai.examsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.domain.entity.UserBatch;


public interface UserBatchRepository extends JpaRepository<UserBatch, Integer> {
    public List<UserBatch> findByUser(User user);

    public List<UserBatch> findByBatch(Batch batch);

    public List<UserBatch> findAllByBatch(Batch batch);
}
