package com.example.student.Repositories;

import com.example.student.Entities.Academisions;
import com.example.student.Entities.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lessons, Integer> {
    Lessons findByDersKodu(String dersKodu);
}
