package com.example.student.Services.Impl;

import com.example.student.Entities.Academisions;
import com.example.student.Repositories.AcademisionRepository;
import com.example.student.Services.AcademisionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AcademisionServiceImpl implements AcademisionService {
    private AcademisionRepository academisionRepository;
    @Autowired
    public AcademisionServiceImpl(AcademisionRepository academisionRepository) {
        this.academisionRepository = academisionRepository;
    }
    @Override
    public Academisions saveAcademision(Academisions academision) {

        return academisionRepository.save(academision);
    }
    @Override
    public List<Academisions> getAllAcademisions() {

        return academisionRepository.findAll();
    }
    @Override
    public Academisions findByTcNo(String tcNo) {
        return academisionRepository.findByTcNo(tcNo) ;
                //.orElseThrow(()-> new EntityNotFoundException("Academision not found")) ;
    }
    @Override
    public void deleteAcademision(Academisions academision) {
        academision.setDeleted(true);
        academisionRepository.save(academision);
    }
    @Override
    public Academisions updateAcademision(Academisions academision){
        return academisionRepository.save(academision);
    }
    @Override
    public Optional<Academisions> findById(Integer id) {
        return academisionRepository.findById(id);
    }
}
