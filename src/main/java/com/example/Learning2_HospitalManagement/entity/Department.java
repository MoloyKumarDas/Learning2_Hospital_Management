package com.example.Learning2_HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 100)
    private String name;

    @OneToOne           // owned side
    private Doctor headDoctor;

    @ManyToMany         // owned side
    @JoinTable(                           // optional
            name="my_dept_doctors",
            joinColumns = @JoinColumn(name="dpt_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private Set<Doctor> doctors=new HashSet<>();
}
