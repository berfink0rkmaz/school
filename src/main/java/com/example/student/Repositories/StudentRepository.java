package com.example.student.Repositories;
import com.example.student.Entities.Academisions;
import com.example.student.Entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
    Students findByTcNo(String tcNo);
    Optional<Students> findById(Integer id);
}
