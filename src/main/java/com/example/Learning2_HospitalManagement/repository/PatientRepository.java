package com.example.Learning2_HospitalManagement.repository;

import com.example.Learning2_HospitalManagement.entity.Patient;
import com.example.Learning2_HospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    List<Patient>findByBloodGroup(@Param("bloodGroup")BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate>:birthDate")            // using param name instead of using ?1 // ?1 this shold be avoided // ?1 increase the chance of sql injection attack
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("select p.bloodGroup,Count(p) from Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroupType();

    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatients();

    @Transactional
    @Modifying
    @Query("update Patient p set p.name=:name where p.id=:id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);
}
