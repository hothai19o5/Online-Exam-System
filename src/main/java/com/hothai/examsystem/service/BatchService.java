package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.repository.BatchRepository;

@Service
public class BatchService {

    private final BatchRepository batchRepository;

    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public List<Batch> getAllBatches() {
        return this.batchRepository.findAll();
    }

    public Batch getBatchById(int id) {
        return this.batchRepository.findOneById(id);
    }

    public void handleSaveBatch(Batch batch) {
        this.batchRepository.save(batch);
    }

    public void handleDeleteBatch(int id) {
        this.batchRepository.deleteById(id);
    }
}
