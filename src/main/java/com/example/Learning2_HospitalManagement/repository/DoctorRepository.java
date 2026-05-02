package com.example.Learning2_HospitalManagement.repository;

import com.example.Learning2_HospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
