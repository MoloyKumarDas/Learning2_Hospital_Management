package com.example.Learning2_HospitalManagement.service;

import com.example.Learning2_HospitalManagement.entity.Appointment;
import com.example.Learning2_HospitalManagement.entity.Doctor;
import com.example.Learning2_HospitalManagement.entity.Patient;
import com.example.Learning2_HospitalManagement.repository.AppointmentRepository;
import com.example.Learning2_HospitalManagement.repository.DoctorRepository;
import com.example.Learning2_HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

@Transactional
public class AppoinmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment,Long doctorId,Long patientId){
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        Patient patient=patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId()!=null) throw new IllegalArgumentException("Appointment should  not have ");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointments().add(appointment);    // to maintain consistency

        return appointmentRepository.save(appointment);

    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId,Long doctorId){
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);            // dirty but don't need to call save manually  // update autometically // as this is under persistence state

        return appointment;

    }

}
