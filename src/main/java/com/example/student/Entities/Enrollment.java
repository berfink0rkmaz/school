package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "lesson_student")
@Entity
@Data
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lesson_id")
    private Integer lessonId;

    @Column(name = "student_id")
    private Integer studentId;

    private int courseCredit;

    private String studentName;
    private String studentSurname;
}