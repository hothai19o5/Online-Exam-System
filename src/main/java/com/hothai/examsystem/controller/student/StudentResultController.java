package com.hothai.examsystem.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentResultController {

    @GetMapping("/student/result")
    public String getStudentResultPage() {
        return "student/result/show";
    }
}
