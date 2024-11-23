package com.hothai.examsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hothai.examsystem.domain.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    public Role findByName(String name);
}
