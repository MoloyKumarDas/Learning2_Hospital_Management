package com.example.Learning2_HospitalManagement;

import com.example.Learning2_HospitalManagement.entity.Appointment;
import com.example.Learning2_HospitalManagement.entity.Insurance;
import com.example.Learning2_HospitalManagement.entity.Patient;
import com.example.Learning2_HospitalManagement.service.AppoinmentService;
import com.example.Learning2_HospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppoinmentService appoinmentService;

    @Test
    public void testInsurance(){
        Insurance insurance=Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient= insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,00,0))
                .reason("Cancer")
                .build();

        var newAppointment= appoinmentService.createNewAppointment(appointment,1L,2L);

        System.out.println(newAppointment);
    }

}
