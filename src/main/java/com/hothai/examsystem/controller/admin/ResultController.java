package com.hothai.examsystem.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultController {

    @GetMapping("/admin/result")
    public String getResultPage() {
        return "admin/result/show";
    }
}
