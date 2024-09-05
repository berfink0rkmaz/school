package com.example.student.Services.Impl;

import com.example.student.Entities.Lessons;
import com.example.student.Repositories.LessonRepository;
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
    public Lessons saveLesson(Lessons lesson) {
        return lessonRepository.save(lesson);
    }
    @Override
    public List<Lessons> getAllLessons() {
        return lessonRepository.findAll();
    }
    @Override
    public Lessons findByDersKodu(String dersKodu) {
        return lessonRepository.findByDersKodu(dersKodu);
    }
    @Override
    public void deleteLesson(Lessons lesson) {
        lesson.setDeleted(true);
        lessonRepository.save(lesson);
    }
    @Override
    public Lessons updateLesson(Lessons lesson) {
        return lessonRepository.save(lesson);
    }
    @Override
    public Optional<Lessons> findLessonById(Integer id) {
        return lessonRepository.findById(id);
    }
}
