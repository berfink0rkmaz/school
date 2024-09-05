package com.example.student.Services;
import com.example.student.Entities.Lessons;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    Lessons saveLesson(Lessons lesson);
    List<Lessons> getAllLessons();
    Lessons findByDersKodu(String dersKodu);
    void deleteLesson(Lessons lesson);
    Lessons updateLesson(Lessons lesson);
    Optional<Lessons> findLessonById(Integer id);
}
