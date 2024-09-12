package com.example.student.Services.Impl;

import com.example.student.Entities.Academician;
import com.example.student.Repositories.AcademicianRepository;
import com.example.student.ResponseMessage.Constants;
import com.example.student.ResponseMessage.GenericResponse;
import com.example.student.Services.AcademicianService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AcademicianServiceImpl implements AcademicianService {
    private final AcademicianRepository academicianRepository;
    @Autowired
    public AcademicianServiceImpl(AcademicianRepository academicianRepository) {
        this.academicianRepository = academicianRepository;
    }
    @Override
    public GenericResponse<?> getAllAcademicians() {
        System.out.println("getAllAcademicians called");
        List<Academician> academicians = academicianRepository.findAll();
        if(academicians.isEmpty()) { return GenericResponse.error(Constants.EMPTY_LIST); }
        else{ return GenericResponse.success(academicians); }
    }

    @Override
    public GenericResponse<?> saveAcademician(Academician academician) {
        System.out.println("save academician called...");
        Academician academicianExists = academicianRepository.findAcademicianById(academician.getId());
        if (academicianExists == null) {
            academicianRepository.save(academician);
            return GenericResponse.success(academician);
        } else {
            return GenericResponse.error(Constants.FOUND_ID);
        }
    }

    @Override
    public GenericResponse<?> findById(Integer id) {
        System.out.println("getAcademicianById called");
        Academician academician = academicianRepository.findAcademicianById(id);
        if(academician==null) {return GenericResponse.error(Constants.EMPTY_ID);}
        else{return GenericResponse.success(academician);}
    }

    @Override
    public GenericResponse<?> deleteAcademician(Integer id) {
        System.out.println("delete academician called...");
        Academician academicianExists = academicianRepository.findAcademicianById(id);
        if(academicianExists == null) {
            return GenericResponse.error(Constants.EMPTY_ID);
        }else {
            academicianExists.setDeleted(true);
            academicianRepository.save(academicianExists);
            return GenericResponse.success(academicianExists);
        }
    }

    @Override
    public GenericResponse<?> updateAcademician(Academician academician){
        System.out.println("update academician called...");
        Academician academicianExists = academicianRepository.findAcademicianById(academician.getId());
        if (academicianExists == null) {
            return GenericResponse.error(Constants.EMPTY_ID);
        } else {
            Academician updatedAcademician = academicianRepository.save(academician);
            return GenericResponse.success(updatedAcademician);
        }
    }
}
