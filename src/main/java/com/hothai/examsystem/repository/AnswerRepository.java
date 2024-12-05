package com.hothai.examsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hothai.examsystem.domain.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Answer findOneById(int id);
    public List<Answer> findByExamIdAndUserId(int examId, int userId);
}
