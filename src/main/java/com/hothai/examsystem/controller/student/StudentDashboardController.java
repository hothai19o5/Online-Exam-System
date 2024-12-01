package com.hothai.examsystem.controller.student;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hothai.examsystem.domain.dto.RegisterDTO;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.service.UserService;

import jakarta.validation.Valid;

@Controller
public class StudentDashboardController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public StudentDashboardController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/student")
    public String getStudentDashboardPage() {
        return "student/exam/show";
    }

    @GetMapping("/student/exam")
    public String getStudentExamPage(Model model) {

        return "student/exam/show";
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
