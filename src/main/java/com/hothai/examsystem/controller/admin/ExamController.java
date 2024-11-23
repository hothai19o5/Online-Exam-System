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

import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.service.ExamService;

import jakarta.validation.Valid;

@Controller
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
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
        return "admin/exam/detail";
    }

    @RequestMapping("/admin/exam/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        Exam exam = this.examService.getExamById(id);
        model.addAttribute("exam", exam);
        return "admin/exam/update";
    }

    @PostMapping("/admin/exam/update")
    public String postUpdateUser(Model model, @ModelAttribute("exam") @Valid Exam dataForm,
            BindingResult userBindingResult) {

        if (userBindingResult.hasErrors()) {
            return "/admin/exam/update";
        }

        Exam currentExam = this.examService.getExamById(dataForm.getId());
        if (currentExam != null) {
            currentExam.setTitle(dataForm.getTitle());
            currentExam.setTotalQuestion(dataForm.getTotalQuestion());
            currentExam.setDuration(dataForm.getDuration());
            currentExam.setExamDesc(dataForm.getExamDesc());
            currentExam.setMarkRight(dataForm.getMarkRight());
            currentExam.setMarkWrong(dataForm.getMarkWrong());
            currentExam.setQuestions(dataForm.getQuestions());
            this.examService.handleSaveExam(currentExam);
        }
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
