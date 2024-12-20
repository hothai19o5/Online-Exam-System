package com.hothai.examsystem.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EnrollTable")
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
        return "Enroll [id=" + id + ", batch=" + batch + ", exam=" + exam + "]";
    }
}
