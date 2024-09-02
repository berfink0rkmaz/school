package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String adi ;

    @Column
    private String dersKredi ;

    @Column
    private String bolum;

    @Column(unique=true)
    private String dersKodu;
}