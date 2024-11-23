package com.hothai.examsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hothai.examsystem.domain.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
    public Question findOneById(long id);


}
