package com.hothai.examsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.domain.entity.UserBatch;

public interface UserBatchRepository extends JpaRepository<UserBatch, Integer> {
    // Spring Data JPA không tự động hiểu findBatchByUser vì Batch không chứa thuộc tính user
    @Query(value = "SELECT b.* FROM batch b JOIN user_batch_table ub ON b.id = ub.batch_id WHERE ub.user_id = :userId", nativeQuery = true)
    public List<Batch> findBatchByUser(@Param("user")User user);

    @Query(value = "SELECT u.* FROM user u JOIN user_batch_table ub ON u.id = ub.user_id WHERE ub.batch_id = :batchId", nativeQuery = true)
    public List<User> findUserByBatch(@Param("batch")Batch batch);

    @Modifying
    @Query("INSERT INTO UserBatch (batch, user) VALUES (:batch, :user)")
    void save(@Param("batch") Batch batch, @Param("user") User user);
}
