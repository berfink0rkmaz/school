package com.example.student.Repositories;

import com.example.student.Entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository <Enrollment, Long> {
}
