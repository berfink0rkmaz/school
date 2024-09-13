package com.example.student.Dto;

import com.example.student.Entities.Enrollment;
import com.example.student.Dto.EnrollmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentDto enrollmentToDto(Enrollment enrollment);
    Enrollment enrollmentDtoToEnrollment (EnrollmentDto enrollmentDto);
}
