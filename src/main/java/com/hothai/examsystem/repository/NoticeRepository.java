package com.hothai.examsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hothai.examsystem.domain.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer>{
    public Notice findOneById(long id);

}
