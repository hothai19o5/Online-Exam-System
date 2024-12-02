package com.hothai.examsystem.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentNoticeController {
    @GetMapping("/student/notice")
    public String getStudentNoticePage() {
        return "student/notice";
    }
}
