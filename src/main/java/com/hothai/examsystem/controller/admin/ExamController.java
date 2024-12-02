package com.hothai.examsystem.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.Question;
import com.hothai.examsystem.service.ExamService;
import com.hothai.examsystem.service.QuestionService;

import jakarta.validation.Valid;

@Controller
public class ExamController {
    private final ExamService examService;
    private final QuestionService questionService;

    public ExamController(ExamService examService, QuestionService questionService) {
        this.examService = examService;
        this.questionService = questionService;
    }

    @GetMapping("/admin/exam")
    public String getUserPage(Model model) {
        List<Exam> exams = this.examService.getAllExams();
        model.addAttribute("exams", exams);
        return "admin/exam/show";
    }

    @GetMapping("/admin/exam/{id}")
    public String getDetailUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        Exam exam = this.examService.getExamById(id);
        model.addAttribute("exam", exam);
        List<Question> questions = exam.getQuestions();
        model.addAttribute("questions", questions);
        return "admin/exam/detail";
    }

    @RequestMapping("/admin/exam/update/{id}")
    public String getAddQuestionPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        Exam exam = this.examService.getExamById(id);
        model.addAttribute("exam", exam);
        List<Question> questions = this.questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        return "admin/exam/update";
    }

    @PostMapping("/admin/exam/update")
    public String postUpdateUser(Model model, @RequestParam("questionIds") List<Integer> questionIds, @RequestParam("examId") int examId) {
         // Log dữ liệu nhận được
         System.out.println("Exam ID: " + examId);
         System.out.println("Selected Questions: " + questionIds);
         this.examService.addQuestionToExam(examId, questionIds);
        return "redirect:/admin/exam";
    }

    @GetMapping("/admin/exam/create") // GET
    public String getCreateUserPage(Model model) {
        model.addAttribute("newExam", new Exam());
        return "admin/exam/create";
    }

    @PostMapping("/admin/exam/create")
    public String createUserPage(Model model, @ModelAttribute("newExam") @Valid Exam dataForm,
            BindingResult newUserBindingResult) {

        if (newUserBindingResult.hasErrors()) {
            return "/admin/exam/create";
        }

        this.examService.handleSaveExam(dataForm);

        return "redirect:/admin/exam";
    }

    @PostMapping("/admin/exam/delete")
    public String postDeleteUser(Model model, @ModelAttribute("id") int id) {
        this.examService.handleDeleteExam(id);
        return "redirect:/admin/exam";
    }

    @GetMapping("/admin/exam/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        Exam exam = this.examService.getExamById(id);
        model.addAttribute("exam", exam);
        return "admin/exam/delete";
    }
}
