package com.hothai.examsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hothai.examsystem.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findOneById(long id);
    public User findByEmail(String email);
    public User findByUsername(String username);
    public boolean existsByEmail(String email);
    public List<User> findAllByRoleName(String roleName);
}
