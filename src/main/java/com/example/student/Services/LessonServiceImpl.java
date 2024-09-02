package com.example.student.Services;

import com.example.student.Entities.Lessons;
import com.example.student.Repositories.LessonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
    @Override
    public Lessons saveLesson(Lessons lesson) {
        return lessonRepository.save(lesson);
    }

}
