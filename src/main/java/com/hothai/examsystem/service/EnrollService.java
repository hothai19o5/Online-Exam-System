package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.repository.EnrollRepository;

@Service
public class EnrollService {

    private final EnrollRepository enrollRepository;

    public EnrollService(EnrollRepository enrollRepository) {
        this.enrollRepository = enrollRepository;
    }

    public List<Exam> getExamsByBatch(Batch batch) {
        return this.enrollRepository.findExamsByBatch(batch);
    }
}
