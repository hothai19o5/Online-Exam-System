package com.hothai.examsystem.domain.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "BatchTable")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String scholastic;

    @OneToMany(mappedBy = "batch")
    private Set<Enroll> enrolls;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Enroll> getEnrolls() {
        return enrolls;
    }
    public void setEnrolls(Set<Enroll> enrolls) {
        this.enrolls = enrolls;
    }
    public String getScholastic() {
        return scholastic;
    }
    public void setScholastic(String scholastic) {
        this.scholastic = scholastic;
    }

    @Override
    public String toString() {
        return "Batch [id=" + id + ", name=" + name + ", scholastic=" + scholastic + ", enrolls=" + enrolls + ", users=" + "]";
    }
}