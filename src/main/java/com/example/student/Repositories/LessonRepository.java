package com.example.student.Repositories;

import com.example.student.Entities.Academisions;
import com.example.student.Entities.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lessons, Integer> {
    Lessons findByDersKodu(String dersKodu);
    Optional<Lessons> findById(Integer id) ;
}
