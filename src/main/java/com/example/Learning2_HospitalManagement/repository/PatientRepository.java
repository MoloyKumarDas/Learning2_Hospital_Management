package com.example.Learning2_HospitalManagement.repository;

import com.example.Learning2_HospitalManagement.entity.Patient;
import com.example.Learning2_HospitalManagement.entity.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate,String email);

    List<Patient>findByBirthDateBetween(LocalDate startDate,LocalDate endDate);
    List<Patient>findByNameContaining(String query);

    List<Patient>findByNameContainingOrderByIdDesc(String query);

    @Query("select p from Patient p where p.bloodGroup=?1")             // @Query states for custom query
    List<Patient>findByBloodGroup(@Param("bloodGroup")BloodGroupType bloodGroupType);

}
