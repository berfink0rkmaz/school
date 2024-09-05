package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Where(clause = "deleted = false")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String adi ;

    @Column
    private String soyadi ;

    @Column
    private String bolum;

    @Column (unique = true, nullable = false)
    private String tcNo;

    @Column(unique = true)
    private String email;

    private boolean deleted = false;

   @ManyToMany(mappedBy = "selectedLessons")
   private List<Lessons> selects = new ArrayList<>();
}
