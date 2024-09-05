package com.example.student.Services;

import com.example.student.Entities.Academisions;

import java.util.List;
import java.util.Optional;

public interface AcademisionService {
    Academisions saveAcademision(Academisions academision);
    List<Academisions> getAllAcademisions();
    Academisions updateAcademision(Academisions academision);
    Academisions findByTcNo(String tcNo);
    void deleteAcademision(Academisions academision);
    Optional<Academisions> findById(Integer id);
}
