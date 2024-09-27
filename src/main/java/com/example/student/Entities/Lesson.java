package com.example.student.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
    private int quota;

    @Column
    private String semester;

    @Column
    private int year;

    private boolean deleted = false ;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "lesson_student",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"))
    private List<Student> studentList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "lesson_academician",
            joinColumns = @JoinColumn(name = "academician_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"))
    private Academician academist;

}