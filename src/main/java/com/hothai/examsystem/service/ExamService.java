package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.repository.ExamRepository;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
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
}
