package com.example.student.Services;
import com.example.student.Entities.Lesson;
import com.example.student.ResponseMessage.GenericResponse;

public interface LessonService {
    GenericResponse<?> getAllLessons();
    GenericResponse<?> saveLesson(Lesson lesson);
    GenericResponse<?> findById(Integer id);
    GenericResponse<?> deleteLesson(Integer Id);
    GenericResponse<?> updateLesson(Lesson lesson);
}
