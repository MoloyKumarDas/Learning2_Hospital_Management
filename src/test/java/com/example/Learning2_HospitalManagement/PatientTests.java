package com.example.Learning2_HospitalManagement;

import com.example.Learning2_HospitalManagement.entity.Patient;
import com.example.Learning2_HospitalManagement.repository.PatientRepository;
import com.example.Learning2_HospitalManagement.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient>patientList=patientRepository.findAll();
        System.out.println(patientList);

        Patient p1=new Patient();
        patientRepository.save(p1);
    }

    @Test
    public void testTransactionMethods() {
       // Patient patient = patientService.getPatientById(1L);

       //Patient patient=patientRepository.findById(1L).orElseThrow(()->new EntityNotFoundException("Patient not "+ "found with id: 1"));

        //Patient patient=patientRepository.findByName("Diya Patel");

        List<Patient>patientList=patientRepository.findByBirthDateOrEmail(LocalDate.of(1988,5,10),"diyapatel@example.com");

        for(Patient patient:patientList) {
            System.out.println(patient);
        }
    }
}
