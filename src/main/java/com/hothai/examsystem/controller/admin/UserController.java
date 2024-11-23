package com.hothai.examsystem.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.service.UploadService;
import com.hothai.examsystem.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;
    private final UploadService uploadService;

    public UserController(UserService userService, UploadService uploadService) {
        this.userService = userService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/{id}")
    public String getDetailUserPage(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("user") @Valid User dataForm,
            BindingResult userBindingResult, @RequestParam("nameAvatarFile") MultipartFile file) {

        if (userBindingResult.hasErrors()) {
            return "/admin/user/update";
        }

        User currentUser = this.userService.getUserById(dataForm.getId());
        if (currentUser != null) {
            currentUser.setUsername(dataForm.getUsername());
            currentUser.setPhone(dataForm.getPhone());
            currentUser.setRole(this.userService.getRoleByName(dataForm.getRole().getName()));
            currentUser.setAvatar(this.uploadService.handleSaveUploadFile(file, "avatar"));
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/create") // GET
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") @Valid User dataForm,
            BindingResult newUserBindingResult, @RequestParam("nameAvatarFile") MultipartFile file) {

        if (newUserBindingResult.hasErrors()) {
            return "/admin/user/create";
        }

        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        dataForm.setAvatar(avatar);
        dataForm.setRole(this.userService.getRoleByName(dataForm.getRole().getName()));
        dataForm.setPassword(dataForm.getPassword());
        this.userService.handleSaveUser(dataForm);
        return "redirect:/admin/user";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("id") int id) {
        this.userService.handleDeleteUser(id);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/delete";
    }
}
