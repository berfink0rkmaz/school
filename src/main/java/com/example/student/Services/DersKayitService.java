package com.example.student.Services;

import com.example.student.DersKayitDto;
import com.example.student.Entities.DersKayit;
import com.example.student.GenericResponse;
import org.springframework.stereotype.Service;

@Service
public interface DersKayitService {
    //List<DersKayit> getAllDersKayit();
    GenericResponse<?> saveDersKayit(DersKayitDto dersKayitDto);
    //void controlKredi(DersKayitDto dersKayitDto);
    //boolean controlDers(Integer studentId);

}
