package com.example.student.Services;
import com.example.student.Entities.Lessons;

import java.util.List;

public interface LessonService {
    Lessons saveLesson(Lessons lesson);
    List<Lessons> getAllLessons();
}
