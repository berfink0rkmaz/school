package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.With;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

//@Table(name="Academisions")
@Where(clause="deleted = false")
@Data
@Entity
public class Academisions {

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

  //  @Column
   // private String dersKodu;

    @Column(unique = true)
    private String email;

    private boolean deleted = false;

    @ManyToMany(mappedBy = "givenLessons",cascade = CascadeType.ALL)
    private List<Lessons> givens = new ArrayList<>();


}