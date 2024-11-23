package com.hothai.examsystem.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentDashboardController {

    @GetMapping("/student")
    public String getStudentDashboardPage() {
        return "student/exam/show";
    }
}
