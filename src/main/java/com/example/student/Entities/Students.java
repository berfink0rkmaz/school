package com.example.student.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

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

    @Column
    private String telefon;

    @Column
    private LocalDate dogumTarihi;

    private LocalDate bugunTarihi = LocalDate.now();


    @Column
    private int yas; //calculateAge(dogumTarihi,bugunTarihi);

    @Column
    private String cinsiyet;

    private boolean deleted = false;

   @ManyToMany(mappedBy = "SecenOgrenciler",cascade = CascadeType.ALL)
   private List<Lessons> SecilenDersler = new ArrayList<>();

   int calculateAge(LocalDate dogumTarihi, LocalDate bugunTarihi){
       Period period = Period.between(dogumTarihi, bugunTarihi);

       return period.getYears();    }
}
