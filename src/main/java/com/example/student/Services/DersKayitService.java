package com.example.student.Services;

import com.example.student.DersKayitDto;
import com.example.student.Entities.DersKayit;
import org.springframework.stereotype.Service;

@Service
public interface DersKayitService {
    //List<DersKayit> getAllDersKayit();
    DersKayit saveDersKayit(DersKayitDto dersKayitDto);
    //void controlKredi(DersKayitDto dersKayitDto);
    //boolean controlDers(Integer studentId);

}
