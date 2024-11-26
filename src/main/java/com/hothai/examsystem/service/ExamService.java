package com.hothai.examsystem.service;

import java.util.List;

import com.hothai.examsystem.domain.entity.Question;
import com.hothai.examsystem.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.repository.ExamRepository;

@Service
public class ExamService {

    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;

    public ExamService(ExamRepository examRepository, QuestionRepository questionRepository) {
        this.examRepository = examRepository;
        this.questionRepository = questionRepository;
    }

    public List<Exam> getAllExams() {
        return this.examRepository.findAll();
    }

    public Exam getExamById(long id) {
        return this.examRepository.findOneById(id);
    }

    public void handleSaveExam(Exam exam) {
        this.examRepository.save(exam);
    }

    public void handleDeleteExam(int id) {
        this.examRepository.deleteById(id);
    }

    public void addQuestionToExam(int ExamId, List<Integer> questionIds) {
        Exam exam = this.examRepository.findOneById(ExamId);
        List<Question> questions = this.questionRepository.findAllById(questionIds);
        exam.getQuestions().addAll(questions);
        this.examRepository.save(exam);
    }
}
