package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Where(clause = "deleted = false")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private int courseCredit;

    @Column
    private String department;

    @Column(unique=true)
    private String courseCode;

    @Column
    private String semester;

    @Column
    private int year;

    private boolean deleted = false ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "lesson_student",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"))
    private List<Student> studentList = new ArrayList<Student>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "lesson_academician",
            joinColumns = @JoinColumn(name = "academision_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"))
    private Academician academician = new Academician();

}