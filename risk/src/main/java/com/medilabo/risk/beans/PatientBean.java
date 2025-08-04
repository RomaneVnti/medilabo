package com.openclassrooms.risk.beans;

import lombok.Data;
import java.time.LocalDate;

/**
 * Bean représentant un patient.
 * <p>
 * Contient les informations personnelles du patient telles que
 * l'identifiant, le prénom, le nom, la date de naissance, le sexe,
 * l'adresse et le numéro de téléphone.
 * </p>
 */
@Data
public class PatientBean {

    /**
     * Identifiant unique du patient.
     */
    private Integer patientListId;

    /**
     * Prénom du patient.
     */
    private String firstName;

    /**
     * Nom de famille du patient.
     */
    private String lastName;

    /**
     * Date de naissance du patient.
     */
    private LocalDate birthdate;

    /**
     * Sexe du patient.
     */
    private String gender;

    /**
     * Adresse du patient.
     */
    private String address;

    /**
     * Numéro de téléphone du patient.
     */
    private String phoneNumber;
}
