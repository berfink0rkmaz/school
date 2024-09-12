package com.example.student.Services.Impl;

import com.example.student.Entities.Academician;
import com.example.student.Entities.Lesson;
import com.example.student.Repositories.LessonRepository;
import com.example.student.ResponseMessage.Constants;
import com.example.student.ResponseMessage.GenericResponse;
import com.example.student.Services.LessonService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public GenericResponse<?> getAllLessons() {
        System.out.println("getAllLessons called");
        List<Lesson> lessons = lessonRepository.findAll();
        if(lessons.isEmpty()) {
            return GenericResponse.error(Constants.EMPTY_LIST);
        }else{
            return GenericResponse.success(lessons);
        }
    }

    @Override
    public GenericResponse<?> saveLesson(Lesson lesson) {
        System.out.println("save lesson called...");
        Lesson lessonExists= lessonRepository.findLessonById(lesson.getId());
        if(lessonExists == null){
            lessonRepository.save(lesson);
            return GenericResponse.success(lesson);
        } else {
            return GenericResponse.error(Constants.FOUND_ID);
        }
    }
    @Override
    public GenericResponse<?> findById(Integer id) {
        System.out.println("getLessonById called");
        Lesson lesson =lessonRepository.findLessonById(id);
        if (lesson==null) {
            return GenericResponse.error(Constants.EMPTY_ID);
        }else{
            return GenericResponse.success(lesson);
        }
    }

    @Override
    public GenericResponse<?> deleteLesson(Integer id) {
        System.out.println("delete lesson called...");
        Lesson lessonExists= lessonRepository.findLessonById(id);
        if(lessonExists == null){
            return GenericResponse.error(Constants.EMPTY_ID);
        }else{
            lessonExists.setDeleted(true);
            lessonRepository.save(lessonExists);
            return GenericResponse.success(lessonExists);
        }
    }

    @Override
    public GenericResponse<?> updateLesson(Lesson lesson) {
        System.out.println("update lesson called...");
        Lesson lessonExists= lessonRepository.findLessonById(lesson.getId());
        if(lessonExists == null){
            return GenericResponse.error(Constants.EMPTY_ID);
        }else{
            Lesson updatedLesson= lessonRepository.save(lesson);
            return GenericResponse.success(updatedLesson);
        }
    }

}
