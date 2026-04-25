package com.example.Learning2_HospitalManagement.service;

import com.example.Learning2_HospitalManagement.entity.Patient;
import com.example.Learning2_HospitalManagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient getPatientById(Long id){

        Patient p1=patientRepository.findById(id).orElseThrow();
        Patient p2=patientRepository.findById(id).orElseThrow();

        return p1;
    }
}
