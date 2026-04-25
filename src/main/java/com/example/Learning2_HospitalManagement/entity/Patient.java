package com.example.Learning2_HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter

@Table(                              // update table data   // it doesn't update -> it creates another table
        name = "patient_tbl",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email",columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthday",columnNames = {"name","birthDate"})
        },
        indexes = {
                @Index(name ="idx_patient_birth_date",columnList = "birthDate")
        }

)

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ToString.Exclude
    private LocalDate birthDate;

    private String email;
    private String gender;
}
