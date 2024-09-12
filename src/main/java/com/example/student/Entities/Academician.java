package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

//@Table(name="Academician")
@Where(clause="deleted = false")
@Data
@Entity
public class Academician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String department;

    @Column (unique = true, nullable = false)
    private String tcNo;

    @Column(unique = true)
    private String email;

    private boolean deleted = false;

    @OneToMany(mappedBy = "academist",cascade = CascadeType.ALL)
    private List<Lesson> lessonList = new ArrayList<>();


}