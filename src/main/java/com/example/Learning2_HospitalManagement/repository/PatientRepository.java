package com.example.Learning2_HospitalManagement.repository;

import com.example.Learning2_HospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
