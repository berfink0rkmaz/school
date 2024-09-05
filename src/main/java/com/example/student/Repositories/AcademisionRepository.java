package com.example.student.Repositories;

import com.example.student.Entities.Academisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcademisionRepository extends JpaRepository<Academisions, Integer> {
    Academisions findByTcNo(String tcNo);
    Optional<Academisions> findById(Integer id);
}
