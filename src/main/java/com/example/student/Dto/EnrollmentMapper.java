package com.example.student.Dto;

import com.example.student.Entities.Enrollment;
import com.example.student.Dto.EnrollmentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentDto enrollmentToDto(Enrollment enrollment);
    Enrollment enrollmentDtoToEnrollment (EnrollmentDto enrollmentDto);
}
