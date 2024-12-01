package com.hothai.examsystem.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hothai.examsystem.service.ExamService;
import com.hothai.examsystem.service.NoticeService;
import com.hothai.examsystem.service.QuestionService;
import com.hothai.examsystem.service.ResultService;
import com.hothai.examsystem.service.UserService;

@Controller
public class DashboardController {

    private final UserService userService;
    private final ExamService examService;
    private final NoticeService noticeService;
    private final QuestionService questionService;
    private final ResultService resultService;

    public DashboardController(UserService userService, ExamService examService, NoticeService noticeService,
            QuestionService questionService, ResultService resultService) {
        this.userService = userService;
        this.examService = examService;
        this.noticeService = noticeService;
        this.questionService = questionService;
        this.resultService = resultService;
    }

    @GetMapping("/admin")
    public String getDashBoard(Model model) {
        model.addAttribute("totalUser", this.userService.getAllUserByRole("STUDENT").size());
        model.addAttribute("totalExam", this.examService.getAllExams().size());
        model.addAttribute("totalNotice", this.noticeService.getAllNotices().size());
        model.addAttribute("totalQuestion", this.questionService.getAllQuestions().size());
        model.addAttribute("totalResult", this.resultService.getAllResults().size());

        return "admin/dashboard";
    }
}
