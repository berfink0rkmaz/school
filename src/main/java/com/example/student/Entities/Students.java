package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Students {
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
    private int tcNo;

    @Column(unique = true)
    private String email;
}
