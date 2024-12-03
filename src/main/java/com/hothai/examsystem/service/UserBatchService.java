package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.repository.BatchRepository;
import com.hothai.examsystem.repository.UserBatchRepository;
import com.hothai.examsystem.repository.UserRepository;

@Service
public class UserBatchService {

    private final UserBatchRepository userBatchRepository;
    private final BatchRepository batchRepository;
    private final UserRepository userRepository;

    public UserBatchService(UserBatchRepository userBatchRepository, BatchRepository batchRepository, UserRepository userRepository) {
        this.userBatchRepository = userBatchRepository;
        this.batchRepository = batchRepository;
        this.userRepository = userRepository;
    }

    public List<Batch> getBatchByUser(User user) {
        return this.userBatchRepository.findBatchByUser(user);
    }

    public List<User> getUserByBatch(Batch batch) {
        return this.userBatchRepository.findUserByBatch(batch);
    }

    public void addUserToBatch(int batchId, List<Integer> userIds) {
        Batch batch = this.batchRepository.findOneById(batchId);
        List<User> users = this.userRepository.findAllById(userIds);
        for(User user : users) {
            this.userBatchRepository.save(batch, user);
        }
    }
}
