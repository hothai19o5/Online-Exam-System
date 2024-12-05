package com.hothai.examsystem.controller.student;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hothai.examsystem.domain.entity.Answer;
import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.Result;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.service.AnswerService;
import com.hothai.examsystem.service.ResultService;
import com.hothai.examsystem.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentResultController {

    private final UserService userService;
    private final ResultService resultService;
    private final AnswerService answerService;

    public StudentResultController(UserService userService, ResultService resultService, AnswerService answerService) {
        this.userService = userService;
        this.resultService = resultService;
        this.answerService = answerService;
    }

    @GetMapping("/student/result")
    public String getStudentResultPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("id");
        User user = this.userService.getUserById(id);
        List<Result> results = this.resultService.getByUser(user);
        model.addAttribute("results", results);

        return "student/result/show";
    }

    @GetMapping("/student/result/{id}")
    public String getStudentResultDetailPage(Model model, @PathVariable("id") Integer id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("id");

        Result result = this.resultService.getResultById(id);
        model.addAttribute("result", result);
        Exam exam = result.getExam();

        List<Answer> answers = this.answerService.getByExamAndUser(exam.getId(), userId);
        model.addAttribute("answers", answers);
        return "student/result/detail";
    }
}
