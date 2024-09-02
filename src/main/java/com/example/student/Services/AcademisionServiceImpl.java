package com.example.student.Services;

import com.example.student.Entities.Academisions;
import com.example.student.Repositories.AcademisionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
