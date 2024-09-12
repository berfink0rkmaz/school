package com.example.student.Repositories;

import com.example.student.Entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    Lesson findLessonById(Integer id) ;
}
