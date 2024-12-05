package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Answer;
import com.hothai.examsystem.repository.AnswerRepository;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void saveAnswer(Answer submitAnswer) {
        this.answerRepository.save(submitAnswer);
    }

    public List<Answer> getByExamAndUser(int examId, int userId) {
        return this.answerRepository.findByExamIdAndUserId(examId, userId);
    }
}
