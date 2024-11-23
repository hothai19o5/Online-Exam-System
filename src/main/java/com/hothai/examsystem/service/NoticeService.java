package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.entity.Notice;
import com.hothai.examsystem.repository.NoticeRepository;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<Notice> getAllNotices() {
        return this.noticeRepository.findAll();
    }
}
