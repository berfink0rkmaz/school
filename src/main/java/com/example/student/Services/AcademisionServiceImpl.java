package com.example.student.Services;

import com.example.student.Entities.Academisions;
import com.example.student.Repositories.AcademisionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Academisions findbyTcNo(String tcNo) {
        return academisionRepository.findByTcNo(tcNo) ;
                //.orElseThrow(()-> new EntityNotFoundException("Academision not found")) ;
    }
    @Override
    public void deleteAcademision(Academisions academision) {
        academisionRepository.delete(academision);
    }

    /*@Override
    public Academisions updateAcademision(int id, Academisions academisionDetails){
        Academisions academision = academisionRepository.findById(id).orElseThrow();
        academision.setAdi(academisionDetails.getAdi());
        academision.setSoyadi(academisionDetails.getSoyadi());
        return academisionRepository.save(academision);
    }*/
}
