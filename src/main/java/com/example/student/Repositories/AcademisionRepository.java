package com.example.student.Repositories;

import com.example.student.Entities.Academisions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademisionRepository extends JpaRepository<Academisions, Integer> {
}
