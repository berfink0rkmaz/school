package com.example.student.Repositories;

import com.example.student.Entities.Academician;
import com.example.student.ResponseMessage.GenericResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcademicianRepository extends JpaRepository<Academician, Integer> {
    Academician findAcademicianById(Integer id);
}
