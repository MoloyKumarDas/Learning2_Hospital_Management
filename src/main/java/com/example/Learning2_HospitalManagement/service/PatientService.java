package com.example.Learning2_HospitalManagement.service;

import com.example.Learning2_HospitalManagement.entity.Patient;
import com.example.Learning2_HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    //private final EntityManager entityManager;          // don't need to use  // important term

    @Transactional                  // rollback if not execute completely      // if error->rollback
    public Patient getPatientById(Long id){

        Patient p1=patientRepository.findById(id).orElseThrow();
        Patient p2=patientRepository.findById(id).orElseThrow();

        System.out.println(p1==p2);

        p1.setName("yoyo");

        //patientRepository.save(p1);   // don't need this

        return p1;
    }
}
