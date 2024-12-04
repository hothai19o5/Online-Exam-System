package com.hothai.examsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.domain.entity.UserBatch;
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
        List<UserBatch> userBatchs = this.userBatchRepository.findByUser(user);
        List<Batch> batchs = new ArrayList<>();
        for(UserBatch userBatch : userBatchs) {
            batchs.add(userBatch.getBatch());
        }
        return batchs;
    }

    public List<User> getUserByBatch(Batch batch) {
        List<UserBatch> userBatchs = this.userBatchRepository.findByBatch(batch);
        List<User> users = new ArrayList<>();
        for(UserBatch userBatch : userBatchs) {
            users.add(userBatch.getUser());
        }
        return users;
    }

    public void addUserToBatch(int batchId, List<Integer> userIds) {
        Batch batch = this.batchRepository.findOneById(batchId);
        List<User> users = this.userRepository.findAllById(userIds);
        for(User user : users) {
            UserBatch userBatch = new UserBatch();
            userBatch.setBatch(batch);
            userBatch.setUser(user);
            this.userBatchRepository.save(userBatch);
        }
        List<UserBatch> userBatches = this.userBatchRepository.findAllByBatch(batch);
        batch.setQuantityStudent(userBatches.size());
    }

    public void deleteByBatchId(int batchId) {
        Batch batch = this.batchRepository.findOneById(batchId);
        List<UserBatch> userBatches = this.userBatchRepository.findAllByBatch(batch);
        for(UserBatch userBatch : userBatches) {
            this.userBatchRepository.delete(userBatch);
        }
    }
}
