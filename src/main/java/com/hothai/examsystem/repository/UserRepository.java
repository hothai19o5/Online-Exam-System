package com.hothai.examsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hothai.examsystem.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findOneById(long id);
    public User findByEmail(String email);
}
