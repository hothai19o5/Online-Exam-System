package com.hothai.examsystem.controller.student;

import com.hothai.examsystem.domain.entity.Answer;
import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.Question;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.service.AnswerService;
import com.hothai.examsystem.service.ExamService;
import com.hothai.examsystem.service.QuestionService;
import com.hothai.examsystem.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ExamWindowController {

    private final ExamService examService;
    private final QuestionService questionService;
    private final UserService userService;
    private final AnswerService answerService;

    public ExamWindowController(ExamService examService, QuestionService questionService, UserService userService, AnswerService answerService) {
        this.examService = examService;
        this.questionService = questionService;
        this.userService = userService;
        this.answerService = answerService;
    }

    @GetMapping("/student/exam/{id}")
    public String getExamWindowPage(Model model, @PathVariable("id") Integer id) {
        Exam exam = this.examService.getExamById(id);
        model.addAttribute("exam", exam);
        List<Question> questions = exam.getQuestions();
        model.addAttribute("questions", questions);

        return "student/exam/detail";
    }

    @PostMapping("/student/exam/submit")
    public String submitExam(HttpServletRequest request, @RequestParam Map<String, String> answers) {

        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("userName");

        User user = this.userService.getUserByUsername(username);
        Exam exam = this.examService.getExamById(1);

        answers.forEach((key, value) -> {
            if(key.equals("_csrf")) {
                return;
            }
            Question question = this.questionService.getQuestionById(Integer.parseInt(key));
            int mark = 0;
            if(question.getAnswer().equals(value)) {
                mark = 1;
            }
            Answer answer = new Answer();
            answer.setExam(exam);
            answer.setUser(user);
            answer.setQuestion(question);
            answer.setOption_value(value);
            answer.setMark(mark);
            this.answerService.saveAnswer(answer);
        });

        return "redirect:/student/exam";
    }
}
