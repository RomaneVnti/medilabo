package com.medilabo.patient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="patient_list")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_list_id")
    private Integer patientListId;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Birthdate is required")
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @NotBlank(message = "Gender is required")
    @Column(name = "gender")
    private String gender;

    // Champs optionnels : pas d'annotation de validation
    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;
}
