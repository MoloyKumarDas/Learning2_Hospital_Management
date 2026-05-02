package com.example.Learning2_HospitalManagement.service;

import com.example.Learning2_HospitalManagement.entity.Insurance;
import com.example.Learning2_HospitalManagement.entity.Patient;
import com.example.Learning2_HospitalManagement.repository.InsuranceRepository;
import com.example.Learning2_HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient=patientRepository.findById(patientId)
                .orElseThrow(()->new EntityNotFoundException("patient not found with id: "+patientId));

        patient.setInsurance(insurance);         // dirty
        insurance.setPatient(patient);          // bidirectional consistency maintainance

    return patient;
    }

}
