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
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.service.BatchService;
import com.hothai.examsystem.service.UserBatchService;
import com.hothai.examsystem.service.UserService;

import jakarta.validation.Valid;

@Controller
public class BatchController {

    private final BatchService batchService;
    private final UserBatchService userBatchService;
    private final UserService userService;

    public BatchController(BatchService batchService, UserBatchService userBatchService, UserService userService) {
        this.batchService = batchService;
        this.userBatchService = userBatchService;
        this.userService = userService;
    }

    @GetMapping("/admin/batch")
    public String getBatchPage(Model model) {
        List<Batch> batches = this.batchService.getAllBatches();
        model.addAttribute("batches", batches);
        return "admin/classes/show";
    }

    @GetMapping("/admin/batch/{id}")
    public String getDetailBatchPage(Model model, @PathVariable int id) {
        Batch batch = this.batchService.getBatchById(id);
        model.addAttribute("batch", batch);
        List<User> users = this.userBatchService.getUserByBatch(batch);
        model.addAttribute("users", users);
        return "admin/classes/detail";
    }

    @RequestMapping("/admin/batch/update/{id}")
    public String getAddQuestionPage(Model model, @PathVariable int id) {
        Batch batch = this.batchService.getBatchById(id);
        model.addAttribute("batch", batch);
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users", users);
        return "admin/classes/update";
    }

    @PostMapping("/admin/batch/update")
    public String postUpdateUser(Model model, @RequestParam("userId") List<Integer> userId, @RequestParam("batchId") int batchId) {
        this.userBatchService.addUserToBatch(batchId, userId);
        return "redirect:/admin/batch";
    }

    @GetMapping("/admin/batch/create") // GET
    public String getCreateUserPage(Model model) {
        Batch batch = new Batch();
        model.addAttribute("newBatch", batch);
        return "admin/classes/create";
    }

    @PostMapping("/admin/batch/create")
    public String createUserPage(Model model, @ModelAttribute("newBatch") @Valid Batch dataForm,
            BindingResult newUserBindingResult) {

        if (newUserBindingResult.hasErrors()) {
            return "/admin/classes/create";
        }

        this.batchService.handleSaveBatch(dataForm);

        return "redirect:/admin/batch";
    }

    @PostMapping("/admin/batch/delete")
    public String postDeleteUser(Model model, @ModelAttribute("id") int id) {
        return "redirect:/admin/batch";
    }

    @GetMapping("/admin/batch/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable int id) {
        Batch batch = this.batchService.getBatchById(id);
        String name = batch.getName();
        String scholastic = batch.getScholastic();
        model.addAttribute("name", name);
        model.addAttribute("scholastic", scholastic);
        model.addAttribute("id", id);
        return "admin/classes/delete";
    }
}
