package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;

//@Table(name="Academisions")
@Data
@Entity
public class Academisions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String adi ;

    @Column
    private String soyadi ;

    @Column
    private String bolum;

    @Column (unique = true, nullable = false)
    private int tc_no;

  //  @Column
   // private String dersKodu;

    @Column(unique = true)
    private String email;
}