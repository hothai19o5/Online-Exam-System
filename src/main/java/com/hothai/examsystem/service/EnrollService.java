package com.hothai.examsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.Enroll;
import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.repository.BatchRepository;
import com.hothai.examsystem.repository.EnrollRepository;
import com.hothai.examsystem.repository.ExamRepository;

@Service
public class EnrollService {

    private final EnrollRepository enrollRepository;
    private final BatchRepository batchRepository;
    private final ExamRepository examRepository;

    public EnrollService(EnrollRepository enrollRepository, BatchRepository batchRepository, ExamRepository examRepository) {
        this.enrollRepository = enrollRepository;
        this.batchRepository = batchRepository;
        this.examRepository = examRepository;
    }

    public List<Exam> getExamsByBatch(Batch batch) {
        List<Enroll> enrolls = this.enrollRepository.findByBatch(batch);
        List<Exam> exams = new ArrayList<>();
        for(Enroll enroll : enrolls) {
            exams.add(enroll.getExam());
        }
        return exams;
    }

    public void addExamToBatch(int batchId, List<Integer> examIds) {
        Batch batch = this.batchRepository.findOneById(batchId);
        List<Exam> exams = this.examRepository.findAllById(examIds);
        for(Exam exam : exams) {
            Enroll enroll = new Enroll();
            enroll.setBatch(batch);
            enroll.setExam(exam);
            this.enrollRepository.save(enroll);
        }
    }

    public void deleteByBatchId(int batchId) {
        Batch batch = this.batchRepository.findOneById(batchId);
        List<Enroll> enrolls = this.enrollRepository.findByBatch(batch);
        for(Enroll enroll : enrolls) {
            this.enrollRepository.delete(enroll);
        }
    }
}
