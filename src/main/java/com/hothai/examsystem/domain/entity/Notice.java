package com.hothai.examsystem.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "NoticeTable")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String title;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String notiDesc;

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
    public String getNotiDesc() {
        return notiDesc;
    }
    public void setNotiDesc(String notiDesc) {
        this.notiDesc = notiDesc;
    }
    @Override
    public String toString() {
        return "Notice [id=" + id + ", title=" + title + ", notiDesc=" + notiDesc + "]";
    }
}
