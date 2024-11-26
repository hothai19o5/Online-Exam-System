package com.hothai.examsystem.domain.entity;

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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "QuestionTable")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotEmpty(message = "Question Description cannot empty")
    @Column(columnDefinition = "TEXT")
    private String questionDesc;

    @NotNull
    @NotEmpty(message = "Option cannot empty")
    private String option1;

    @NotNull
    @NotEmpty(message = "Option cannot empty")
    private String option2;

    @NotNull
    @NotEmpty(message = "Option cannot empty")
    private String option3;

    @NotNull
    @NotEmpty(message = "Option cannot empty")
    private String option4;

    @NotNull
    @NotEmpty(message = "Option cannot empty")
    private String answer;

    @ManyToMany()
    @JoinTable(name = "exam_question",
        joinColumns ={ @JoinColumn(name = "question_id")},
        inverseJoinColumns ={ @JoinColumn(name = "exam_id")})
    private Set<Exam> exams;

    @OneToMany(mappedBy = "question")
    private Set<Answer> answers;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestionDesc() {
        return questionDesc;
    }
    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }
    public String getOption1() {
        return option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public String getOption4() {
        return option4;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public Set<Exam> getExams() {
        return exams;
    }
    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }
    public Set<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
    @Override
    public String toString() {
        return "Question [id=" + id + ", questionDesc=" + questionDesc + ", option1=" + option1 + ", option2=" + option2
                + ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer + ", answers=" + answers + "]";
    }
}
