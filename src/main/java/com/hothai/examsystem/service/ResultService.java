package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Result;
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
}
