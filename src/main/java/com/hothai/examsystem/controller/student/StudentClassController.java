package com.hothai.examsystem.controller.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.Result;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.service.BatchService;
import com.hothai.examsystem.service.EnrollService;
import com.hothai.examsystem.service.ResultService;
import com.hothai.examsystem.service.UserBatchService;
import com.hothai.examsystem.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class StudentClassController {

    private final UserService userService;
    private final UserBatchService userBatchService;
    private final EnrollService enrollService;
    private final BatchService batchService;
    private final ResultService resultService;

    public StudentClassController(UserService userService, UserBatchService userBatchService, EnrollService enrollService,
                                    BatchService batchService, ResultService resultService) {
        this.userService = userService;
        this.userBatchService = userBatchService;
        this.enrollService = enrollService;
        this.batchService = batchService;
        this.resultService = resultService;
    }

    @GetMapping("/student/class")
    public String getStudentClassPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("id");
        User user = this.userService.getUserById(userId);
        List<Batch> batches = this.userBatchService.getBatchByUser(user);
        model.addAttribute("batches", batches);
        return "student/class/show";
    }

    @GetMapping("/student/class/{id}")
    public String getStudentClassDetailPage(HttpServletRequest request, Model model, @PathVariable("id") int id) {
        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("id");
        User user = this.userService.getUserById(userId);

        Batch batch = this.batchService.getBatchById(id);
        List<Exam> exams = this.enrollService.getExamsByBatch(batch);
        model.addAttribute("exams", exams);

        List<Exam> completedExams = new ArrayList<>();
        List<Exam> uncompletedExams = new ArrayList<>();
        for(Exam exam : exams) {
            Result result = this.resultService.getResultByUserAndExam(user, exam);
            if(result != null) {
                completedExams.add(exam);
            }else {
                uncompletedExams.add(exam);
            }
        }
        model.addAttribute("completedExams", completedExams);
        model.addAttribute("uncompletedExams", uncompletedExams);

        return "student/exam/show";
    }
}
