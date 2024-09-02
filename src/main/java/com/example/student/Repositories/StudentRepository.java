package com.example.student.Repositories;
import com.example.student.Entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Students, Integer> {
   // Optional<Students> findByTcNo(int tcNo);
}
