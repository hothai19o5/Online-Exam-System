package com.hothai.examsystem.controller.student;

import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.Question;
import com.hothai.examsystem.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExamWindowController {

    private final ExamService examService;

    public ExamWindowController(ExamService examService) {this.examService = examService;}

    @GetMapping("/student/exam")
    public String getExamWindowPage(Model model) {
        Exam exam = this.examService.getExamById(1);
        model.addAttribute("exam", exam);
        List<Question> questions = exam.getQuestions();
        model.addAttribute("questions", questions);

        return "student/exam/detail";
    }
}
