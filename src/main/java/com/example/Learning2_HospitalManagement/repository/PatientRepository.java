package com.example.Learning2_HospitalManagement.repository;

import com.example.Learning2_HospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);


}
