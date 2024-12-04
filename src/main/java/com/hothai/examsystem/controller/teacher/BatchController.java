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
import org.springframework.web.bind.annotation.RequestParam;

import com.hothai.examsystem.domain.entity.Batch;
import com.hothai.examsystem.domain.entity.Exam;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.service.BatchService;
import com.hothai.examsystem.service.EnrollService;
import com.hothai.examsystem.service.ExamService;
import com.hothai.examsystem.service.UserBatchService;
import com.hothai.examsystem.service.UserService;

import jakarta.validation.Valid;

@Controller
public class BatchController {

    private final BatchService batchService;
    private final UserBatchService userBatchService;
    private final UserService userService;
    private final ExamService examService;
    private final EnrollService enrollService;

    public BatchController(BatchService batchService, UserBatchService userBatchService, UserService userService,
                            ExamService examService, EnrollService enrollService) {
        this.batchService = batchService;
        this.userBatchService = userBatchService;
        this.userService = userService;
        this.examService = examService;
        this.enrollService = enrollService;
    }

    @GetMapping("/teacher/batch")
    public String getBatchPage(Model model) {
        List<Batch> batches = this.batchService.getAllBatches();
        model.addAttribute("batches", batches);
        return "teacher/classes/show";
    }

    @GetMapping("/teacher/batch/{id}")
    public String getDetailBatchPage(Model model, @PathVariable int id) {
        Batch batch = this.batchService.getBatchById(id);
        model.addAttribute("batch", batch);
        List<User> users = this.userBatchService.getUserByBatch(batch);
        model.addAttribute("users", users);
        return "teacher/classes/detail";
    }

    @RequestMapping("/teacher/batch/update/{id}")
    public String getAddUserPage(Model model, @PathVariable int id) {
        Batch batch = this.batchService.getBatchById(id);
        model.addAttribute("batch", batch);
        List<User> users = this.userService.getAllUserByRole("STUDENT");
        model.addAttribute("users", users);
        return "teacher/classes/update";
    }

    @PostMapping("/teacher/batch/update")
    public String postUpdateUser(Model model, @RequestParam("userId") List<Integer> userId, @RequestParam("batchId") int batchId) {
        this.userBatchService.addUserToBatch(batchId, userId);
        return "redirect:/teacher/batch";
    }

    @RequestMapping("/teacher/batch/addExam/{id}")
    public String getAddExamPage(Model model, @PathVariable int id) {
        Batch batch = this.batchService.getBatchById(id);
        model.addAttribute("batch", batch);
        List<Exam> exams = this.examService.getAllExams();
        model.addAttribute("exams", exams);
        return "teacher/classes/addExam";
    }

    @PostMapping("/teacher/batch/addExam")
    public String postAddExam(Model model, @RequestParam("examId") List<Integer> examId, @RequestParam("batchId") int batchId) {
        this.enrollService.addExamToBatch(batchId, examId);
        return "redirect:/teacher/batch";
    }

    @GetMapping("/teacher/batch/create") // GET
    public String getCreateUserPage(Model model) {
        Batch batch = new Batch();
        model.addAttribute("newBatch", batch);
        return "teacher/classes/create";
    }

    @PostMapping("/teacher/batch/create")
    public String createUserPage(Model model, @ModelAttribute("newBatch") @Valid Batch dataForm,
            BindingResult newUserBindingResult) {

        if (newUserBindingResult.hasErrors()) {
            return "/teacher/classes/create";
        }

        this.batchService.handleSaveBatch(dataForm);

        return "redirect:/teacher/batch";
    }

    @PostMapping("/teacher/batch/delete")
    public String postDeleteUser(Model model, @ModelAttribute("id") int id) {
        this.enrollService.deleteByBatchId(id);
        this.userBatchService.deleteByBatchId(id);
        this.batchService.handleDeleteBatch(id);
        return "redirect:/teacher/batch";
    }

    @GetMapping("/teacher/batch/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable int id) {
        Batch batch = this.batchService.getBatchById(id);
        model.addAttribute("batch", batch);
        model.addAttribute("id", id);
        return "teacher/classes/delete";
    }
}
