package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "lesson_student")
@Entity
@Data
public class DersKayit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lesson_id")
    private Integer lessonId;

    @Column(name = "student_id")
    private Integer studentId;

    private int dersKredi;

    private String ogrenciAdi;
    private String ogrenciSoyadi;

    public void add() {

    }


    /*@ManyToOne
    @JoinColumn(name = "student_id")
    private Students student;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lessons lesson;

    @PrePersist
    @PreUpdate
    public void prePersistUpdate() {
        this.dersKredi = Integer.parseInt(lesson.getDersKredi());
        this.ogrenci = student.getAdi() + " " + student.getSoyadi();*/




}
