package com.example.Learning2_HospitalManagement.entity;

import com.example.Learning2_HospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter

@Table(                              // update table data   // it doesn't update -> it creates another table
        name = "patient",
        uniqueConstraints = {
               // @UniqueConstraint(name = "unique_patient_email",columnNames = {"email"}),
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

    @Column(nullable = false,length = 40)
    private String name;

    //@ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true,nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne
    @JoinColumn(name = "patient_insurance_id")     // owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")        // inverse side
    private List<Appointment> appointmentList;


}
