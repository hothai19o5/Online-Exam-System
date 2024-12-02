package com.hothai.examsystem.controller.student;

import com.hothai.examsystem.domain.entity.Answer;
import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.Question;
import com.hothai.examsystem.domain.entity.Result;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.service.AnswerService;
import com.hothai.examsystem.service.ExamService;
import com.hothai.examsystem.service.QuestionService;
import com.hothai.examsystem.service.ResultService;
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
    private final ResultService resultService;

    public ExamWindowController(ExamService examService, QuestionService questionService, UserService userService,
                                AnswerService answerService, ResultService resultService) {
        this.examService = examService;
        this.questionService = questionService;
        this.userService = userService;
        this.answerService = answerService;
        this.resultService = resultService;
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
        String email = (String) session.getAttribute("email");

        User user = this.userService.getUserByEmail(email);
        Exam exam = this.examService.getExamById(1);

        double totalMark[] = {0};

        answers.forEach((key, value) -> {
            if(key.equals("_csrf")) {
                return;
            }
            Question question = this.questionService.getQuestionById(Integer.parseInt(key));
            int mark = 0;
            if(question.getAnswer().equals(value)) {
                mark = 1;
                totalMark[0] += 1;
            }
            Answer answer = new Answer();
            answer.setExam(exam);
            answer.setUser(user);
            answer.setQuestion(question);
            answer.setOption_value(value);
            answer.setMark(mark);
            this.answerService.saveAnswer(answer);
        });

        Result result = new Result();
        result.setExam(exam);
        result.setUser(user);
        result.setTotalMark(totalMark[0]);
        this.resultService.saveResult(result);

        return "redirect:/student/exam";
    }
}
