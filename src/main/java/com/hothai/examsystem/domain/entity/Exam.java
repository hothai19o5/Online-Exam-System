package com.hothai.examsystem.domain.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ExamTable")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String title;

    @NotNull
    private int duration;

    @NotNull
    private String totalQuestion;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String examDesc;

    @NotNull
    private double markWrong;

    @NotNull
    private double markRight;

    @OneToMany(mappedBy = "exam")
    private Set<Result> results;

    @OneToMany(mappedBy = "exam")
    private Set<Answer> answers;

    @ManyToMany()
    @JoinTable(name = "exam_question",
        joinColumns ={ @JoinColumn(name = "exam_id")},
        inverseJoinColumns ={ @JoinColumn(name = "question_id")})
    private List<Question> questions;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getTotalQuestion() {
        return totalQuestion;
    }
    public void setTotalQuestion(String totalQuestion) {
        this.totalQuestion = totalQuestion;
    }
    public String getExamDesc() {
        return examDesc;
    }
    public void setExamDesc(String examDesc) {
        this.examDesc = examDesc;
    }
    public double getMarkWrong() {
        return markWrong;
    }
    public void setMarkWrong(double markWrong) {
        this.markWrong = markWrong;
    }
    public double getMarkRight() {
        return markRight;
    }
    public void setMarkRight(double markRight) {
        this.markRight = markRight;
    }
    public Set<Result> getResults() {
        return results;
    }
    public void setResults(Set<Result> results) {
        this.results = results;
    }
    public Set<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
    public List<Question> getQuestions() {
        return this.questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    @Override
    public String toString() {
        return "Exam [id=" + id + ", title=" + title + ", duration=" + duration + ", totalQuestion=" + totalQuestion
                + ", examDesc=" + examDesc + ", markWrong=" + markWrong + ", markRight=" + markRight + ", results="
                + results + ", answers=" + answers + "]";
    }
}
