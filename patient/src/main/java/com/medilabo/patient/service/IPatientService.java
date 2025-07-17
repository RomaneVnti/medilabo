package com.medilabo.patient.service;

import com.medilabo.patient.model.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {
    List<Patient> getAllPatient();
    Optional<Patient> getOnePatient(Integer id);
    Patient addPatient(Patient patient);
    void updatePatient(Integer id, Patient patient);
    void deletePatient(Integer id);
}
