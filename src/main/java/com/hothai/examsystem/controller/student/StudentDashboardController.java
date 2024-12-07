package com.hothai.examsystem.controller.student;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hothai.examsystem.domain.dto.RegisterDTO;
import com.hothai.examsystem.domain.entity.Result;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.domain.entity.UserBatch;
import com.hothai.examsystem.service.UploadService;
import com.hothai.examsystem.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentDashboardController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UploadService uploadService;

    public StudentDashboardController(UserService userService, PasswordEncoder passwordEncoder,
                                        UploadService uploadService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.uploadService = uploadService;
    }

    @GetMapping("/student")
    public String getStudentDashboardPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("id");
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        Set<Result> results = user.getResults();
        model.addAttribute("results", results.size());
        Set<UserBatch> userBatches = user.getUserBatches();
        model.addAttribute("classes", userBatches.size());
        return "student/dashboard";
    }

    @GetMapping("/student/profile")
    public String getStudentProfilePage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("id");
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "student/profile/show";
    }

    @PostMapping("/student/profile")
    public String postStudentProfilePage(Model model, @ModelAttribute("user") User dataForm,
                                        @RequestParam("uploadAvatar") MultipartFile file, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("id");

        User currentUser = this.userService.getUserById(id);
        if (currentUser != null) {
            currentUser.setUsername(dataForm.getUsername());
            currentUser.setPhone(dataForm.getPhone());
            if(file == null || file.isEmpty()) {
                currentUser.setAvatar(currentUser.getAvatar());
            } else {
                currentUser.setAvatar(this.uploadService.handleSaveUploadFile(file, "avatar"));
            }
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/student/profile";
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
