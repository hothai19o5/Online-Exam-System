package com.hothai.examsystem.controller.teacher;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hothai.examsystem.domain.entity.Question;
import com.hothai.examsystem.service.QuestionService;

import jakarta.validation.Valid;

@Controller
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/teacher/question")
    public String getQuestionPage(Model model) {
        List<Question> questions = this.questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        return "teacher/question/show";
    }

    @RequestMapping("/teacher/question/update/{id}")
    public String getUpdateQuestionPage(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        Question question = this.questionService.getQuestionById(id);
        model.addAttribute("question", question);
        return "teacher/question/update";
    }

    @PostMapping("/teacher/question/update")
    public String postUpdateQuestion(Model model, @ModelAttribute("question") @Valid Question dataForm,
            BindingResult questionBindingResult) {

        if (questionBindingResult.hasErrors()) {
            return "teacher/question/update";
        }

        Question question = this.questionService.getQuestionById(dataForm.getId());
        question.setTitle(dataForm.getTitle());
        question.setQuestionDesc(dataForm.getQuestionDesc());
        question.setOption1(dataForm.getOption1());
        question.setOption2(dataForm.getOption2());
        question.setOption3(dataForm.getOption3());
        question.setOption4(dataForm.getOption4());
        question.setAnswer(dataForm.getAnswer());

        this.questionService.saveQuestion(question);

        return "redirect:/teacher/question";
    }

    @RequestMapping("/teacher/question/delete/{id}")
    public String getDeleteQuestionPage(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        Question question = this.questionService.getQuestionById(id);
        model.addAttribute("question", question);
        return "teacher/question/delete";
    }

    @PostMapping("/teacher/question/delete")
    public String postDeleteQuestion(Model model, @ModelAttribute("id") int id) {
        this.questionService.deleteQuestion(id);
        return "redirect:/teacher/question";
    }

    @GetMapping("/teacher/question/create") // GET
    public String getCreateQuestionPage(Model model) {
        model.addAttribute("newQuestion", new Question());
        return "teacher/question/create";
    }

    @PostMapping("/teacher/question/create")
    public String createQuestionPage(Model model, @ModelAttribute("newQuestion") @Valid Question dataForm, BindingResult newUserBindingResult) {

        if (newUserBindingResult.hasErrors()) {
            return "/teacher/question/create";
        }

        this.questionService.saveQuestion(dataForm);
        return "redirect:/teacher/question";
    }

}
