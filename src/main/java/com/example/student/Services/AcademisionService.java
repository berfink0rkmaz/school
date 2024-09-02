package com.example.student.Services;

import com.example.student.Entities.Academisions;

import java.util.List;

public interface AcademisionService {
    Academisions saveAcademision(Academisions academision);
    List<Academisions> getAllAcademisions();
    //Academisions updateAcademision(int id, Academisions academisionDetails);
    Academisions findbyTcNo(String tcNo);
    void deleteAcademision(Academisions academision);
}
