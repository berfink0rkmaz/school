package com.example.student.Services.Impl;

import com.example.student.Constants;
import com.example.student.DersKayitDto;
import com.example.student.Entities.DersKayit;
import com.example.student.Entities.Lessons;
import com.example.student.Entities.Students;
import com.example.student.GenericResponse;
import com.example.student.Repositories.LessonRepository;
import com.example.student.Repositories.DersKayitRepository;
import com.example.student.Repositories.StudentRepository;
import com.example.student.Services.DersKayitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class DersKayitServiceImpl implements DersKayitService {
    private final DersKayitRepository dersKayitRepository;
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public DersKayitServiceImpl(DersKayitRepository dersKayitRepository, LessonRepository lessonRepository, StudentRepository studentRepository) {
        this.dersKayitRepository = dersKayitRepository;
        this.lessonRepository = lessonRepository;
        this.studentRepository = studentRepository;
    }
    public int toplamKrediBul(List<Lessons> lessons){
        int toplamKredi=0;
        for (Lessons l : lessons) {
            toplamKredi+=l.getDersKredi();
        }
        return toplamKredi;
    }
    @Override
    public GenericResponse<?> saveDersKayit(DersKayitDto dersKayitDto ) {
        Students student = studentRepository.findById(dersKayitDto.getStudentId()).orElse(null);
        Lessons lesson= lessonRepository.findById(dersKayitDto.getLessonId()).orElse(null);
        List<Lessons> lessonss=student.getSecilenDersler();

        if(!lessonss.contains(dersKayitDto.getLessonId()) && (toplamKrediBul(lessonss)+lesson.getDersKredi() <= 45)) {
            DersKayit dersKayit = new DersKayit();
            dersKayit.setStudentId(dersKayitDto.getStudentId());
            dersKayit.setLessonId(dersKayitDto.getLessonId());
            dersKayit.setDersKredi(lesson.getDersKredi());
            dersKayit.setOgrenciAdi(student.getAdi() == null ? "" : student.getAdi());
            dersKayit.setOgrenciSoyadi(student.getSoyadi() == null ? "" : student.getSoyadi());
            dersKayitRepository.save(dersKayit);

            return GenericResponse.success(dersKayit);

        }else {
            return GenericResponse.error(Constants.Found_ID);
        }

    }


}
