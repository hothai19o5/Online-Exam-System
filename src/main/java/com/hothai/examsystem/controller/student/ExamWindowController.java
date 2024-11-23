package com.hothai.examsystem.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExamWindowController {

    @GetMapping("/student/exam")
    public String getExamWindowPage() {
        return "student/exam/detail";
    }
}
