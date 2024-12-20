package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Question;
import com.hothai.examsystem.repository.QuestionRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return this.questionRepository.findAll();
    }

    public Question getQuestionById(int id) {
        return this.questionRepository.findById(id).orElse(null);
    }

    public void saveQuestion(Question question) {
        this.questionRepository.save(question);
    }

    public void deleteQuestion(int id) {
        this.questionRepository.deleteById(id);
    }
}
