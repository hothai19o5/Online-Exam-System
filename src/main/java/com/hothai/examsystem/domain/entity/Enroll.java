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
@Table(name = "EnrollTable")
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String status;

    @ManyToOne
    @JoinColumn(name="batch_id")
    private Batch batch;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Batch getBatch() {
        return batch;
    }
    public void setBatch(Batch batch) {
        this.batch = batch;
    }
    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    @Override
    public String toString() {
        return "Enroll [id=" + id + ", status=" + status + ", batch=" + batch + ", exam=" + exam + "]";
    }
}
