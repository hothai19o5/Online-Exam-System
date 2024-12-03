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

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.Result;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.service.ResultService;
import com.hothai.examsystem.service.UserService;

import jakarta.validation.Valid;


@Controller
public class ResultController {

    private final ResultService resultService;
    private final UserService userService;

    public ResultController(ResultService resultService, UserService userService) {
        this.resultService = resultService;
        this.userService = userService;
    }

    @GetMapping("/admin/result")
    public String getResultPage(Model model) {
        List<Result> results = this.resultService.getAllResults();
        model.addAttribute("results", results);
        return "admin/result/show";
    }

    @RequestMapping("/admin/result/delete/{id}")
    public String getDeleteQuestionPage(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        Result result = this.resultService.getResultById(id);
        model.addAttribute("result", result);
        return "admin/result/delete";
    }

    @PostMapping("/admin/result/delete")
    public String postDeleteQuestion(Model model, @ModelAttribute("id") int id) {
        this.resultService.deleteById(id);
        return "redirect:/admin/question";
    }

    @RequestMapping("/admin/result/update/{id}")
    public String getAddQuestionPage(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        Result result = this.resultService.getResultById(id);
        model.addAttribute("result", result);
        User user = result.getUser();
        Exam exam = result.getExam();
        model.addAttribute("email", user.getEmail());
        model.addAttribute("title", exam.getTitle());
        model.addAttribute("totalMark", result.getTotalMark());
        return "admin/result/update";
    }

    @PostMapping("/admin/result/update")
    public String postUpdateUser(Model model, @RequestParam("id") int id, @RequestParam("totalMark") double totalMark
                                , @ModelAttribute("result") Result result) {

        Result currenResult = this.resultService.getResultById(id);

        currenResult.setTotalMark(totalMark);

        this.resultService.saveResult(currenResult);

        return "redirect:/admin/result";
    }

}
