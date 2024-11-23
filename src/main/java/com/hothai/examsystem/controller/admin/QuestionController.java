package com.hothai.examsystem.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {

    @GetMapping("/admin/question")
    public String getQuestionPage() {
        return "admin/question/show";
    }
}
