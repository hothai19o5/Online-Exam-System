package com.hothai.examsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.domain.entity.UserBatch;

public interface UserBatchRepository extends JpaRepository<UserBatch, Integer> {
    // Spring Data JPA không tự động hiểu findBatchByUser vì Batch không chứa thuộc tính user
    @Query("SELECT ub.batch FROM UserBatch ub WHERE ub.user = :user")
    public List<Batch> findBatchByUser(User user);
}
