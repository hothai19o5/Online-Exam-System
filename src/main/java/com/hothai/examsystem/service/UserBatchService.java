package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.repository.UserBatchRepository;

@Service
public class UserBatchService {

    private final UserBatchRepository userBatchRepository;

    public UserBatchService(UserBatchRepository userBatchRepository) {
        this.userBatchRepository = userBatchRepository;
    }

    public List<Batch> getBatchByUser(User user) {
        return this.userBatchRepository.findBatchByUser(user);
    }
}
