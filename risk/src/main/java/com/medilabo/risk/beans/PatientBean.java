package com.openclassrooms.risk.beans;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientBean {
    private Integer patientListId;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String gender;
    private String address;
    private String phoneNumber;

}