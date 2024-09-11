package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Where(clause = "deleted = false")
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String adi ;

    @Column
    private int dersKredi ;

    @Column
    private String bolum;

    @Column(unique=true)
    private String dersKodu;

    @Column
    private String dönem;

    @Column
    private int yıl;

    private boolean deleted = false ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "lesson_student",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"))
    private List<Students> SecenOgrenciler = new ArrayList<Students>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "lesson_academision",
            joinColumns = @JoinColumn(name = "academision_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"))
    private List<Academisions> givenLessons = new ArrayList<Academisions>();

}