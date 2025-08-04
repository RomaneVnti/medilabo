package com.medilabo.patient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * Entité représentant un patient dans la base de données.
 */
@Data
@Entity
@Table(name="patient_list")
public class Patient {

    /**
     * Identifiant unique du patient (clé primaire, auto-générée).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_list_id")
    private Integer patientListId;

    /**
     * Prénom du patient. Ne peut pas être vide.
     */
    @NotBlank(message = "First name is required")
    @Column(name = "first_name")
    private String firstName;

    /**
     * Nom de famille du patient. Ne peut pas être vide.
     */
    @NotBlank(message = "Last name is required")
    @Column(name = "last_name")
    private String lastName;

    /**
     * Date de naissance du patient. Ne peut pas être null.
     */
    @NotNull(message = "Birthdate is required")
    @Column(name = "birthdate")
    private LocalDate birthdate;

    /**
     * Genre du patient (ex: "M", "F"). Ne peut pas être vide.
     */
    @NotBlank(message = "Gender is required")
    @Column(name = "gender")
    private String gender;

    /**
     * Adresse du patient. Ce champ est optionnel.
     */
    @Column(name = "address")
    private String address;

    /**
     * Numéro de téléphone du patient. Ce champ est optionnel.
     */
    @Column(name = "phone_number")
    private String phoneNumber;
}
