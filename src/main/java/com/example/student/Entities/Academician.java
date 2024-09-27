package com.example.student.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

//@Table(name="Academician")
@Where(clause="deleted = false")
@Getter
@Setter
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

    @JsonIgnore
    @OneToMany(mappedBy = "academist",cascade = CascadeType.ALL)
    private List<Lesson> lessonList;


}