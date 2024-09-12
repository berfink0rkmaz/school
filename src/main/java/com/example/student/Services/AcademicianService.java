package com.example.student.Services;

import com.example.student.Entities.Academician;
import com.example.student.ResponseMessage.GenericResponse;

public interface AcademicianService {
    GenericResponse<?> getAllAcademicians();
    GenericResponse<?> saveAcademician(Academician academician);
    GenericResponse<?> findById(Integer id);
    GenericResponse<?> deleteAcademician(Integer id);
    GenericResponse<?> updateAcademician(Academician academician);
}
