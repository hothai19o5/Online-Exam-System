package com.hothai.examsystem.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ResultTable")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String mark;

    @NotNull
    private String totalMark;

    @NotNull
    private String status;

    @ManyToOne
    @JoinColumn(name="exam_id")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getTotalMark() {
        return totalMark;
    }
    public void setTotalMark(String totalMark) {
        this.totalMark = totalMark;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Result [id=" + id + ", mark=" + mark + ", totalMark=" + totalMark + ", status=" + status + ", exam="
                + exam + ", user=" + user + "]";
    }
}
