package com.medilabo.patient.controller;

import com.medilabo.patient.model.Patient;
import com.medilabo.patient.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatient();
    }

    @GetMapping("/patients/{id}")
    public Optional<Patient> getOnePatient(@PathVariable Integer id){
        return patientService.getOnePatient(id);
    }

    @PostMapping("/patients")
    public Patient addOnePatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @PutMapping("/patients/{id}")
    public void updatePatient(@RequestBody Patient patient, @PathVariable Integer id){
        patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable Integer id){
        patientService.deletePatient(id);
    }
}
