package com.example.student.Services;

import com.example.student.Entities.Lessons;
import com.example.student.Repositories.LessonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        lessonRepository.delete(lesson);
    }

}
