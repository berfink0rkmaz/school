package com.example.student.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Where(clause = "deleted = false")
public class Student {

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

    @Column
    private LocalDate birthDate;

    private LocalDate todayDate = LocalDate.now();


    @Column
    private int age; //calculateAge(birthDate,todayDate);

    @Column
    private String gender;

    private boolean deleted = false;

   @JsonIgnore
   @ManyToMany(mappedBy = "studentList",cascade = CascadeType.ALL)
   private List<Lesson> takenLessons = new ArrayList<>();

   int calculateAge(LocalDate birthDate, LocalDate todayDate){
       Period period = Period.between(birthDate, todayDate);

       return period.getYears();    }
}
