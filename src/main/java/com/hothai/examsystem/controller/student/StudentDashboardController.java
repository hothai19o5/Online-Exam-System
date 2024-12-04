package com.hothai.examsystem.controller.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hothai.examsystem.domain.dto.RegisterDTO;
import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.Result;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.service.EnrollService;
import com.hothai.examsystem.service.ResultService;
import com.hothai.examsystem.service.UserBatchService;
import com.hothai.examsystem.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentDashboardController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserBatchService userBatchService;
    private final EnrollService enrollService;
    private final ResultService resultService;

    public StudentDashboardController(UserService userService, PasswordEncoder passwordEncoder, UserBatchService userBatchService,
                                        EnrollService enrollService, ResultService resultService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userBatchService = userBatchService;
        this.enrollService = enrollService;
        this.resultService = resultService;
    }

    @GetMapping("/student")
    public String getStudentDashboardPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("id");
        User user = this.userService.getUserById(userId);
        // Sẽ code tiếp tại đây
        return "student/dashboard";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "auth/register";
    }

    @PostMapping("/register")
    public String postRegisterPage(Model model, @ModelAttribute("registerUser") RegisterDTO registerUser) {
        User user = this.userService.registerDTOtoUser(registerUser);
        user.setRole(this.userService.getRoleByName("STUDENT"));
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        this.userService.handleSaveUser(user);
        return "auth/login";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "auth/login";
    }
}
