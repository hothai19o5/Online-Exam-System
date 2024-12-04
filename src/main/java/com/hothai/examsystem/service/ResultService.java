package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.Result;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.repository.ResultRepository;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> getAllResults() {
        return this.resultRepository.findAll();
    }

    public Result getResultById(int id) {
        return this.resultRepository.findOneById(id);
    }

    public void deleteById(int id) {
        this.resultRepository.deleteById(id);
    }

    public void saveResult(Result result) {
        this.resultRepository.save(result);
    }

    public Result getResultByUserAndExam(User user, Exam exam) {
        return this.resultRepository.findByUserAndExam(user, exam);
    }

    public List<Result> getByUser(User user) {
        return this.resultRepository.findByUser(user);
    }
}
