package com.medilabo.patient.controller;

import com.medilabo.patient.model.Patient;
import com.medilabo.patient.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour la gestion des patients.
 * Fournit des endpoints pour créer, lire, mettre à jour et supprimer des patients.
 */
@RestController
@RequestMapping("/api")
public class PatientController {

    /**
     * Service métier utilisé pour accéder aux opérations sur les patients.
     */
    @Autowired
    private IPatientService patientService;

    /**
     * Récupère la liste de tous les patients enregistrés.
     *
     * @return une liste d'objets {@link Patient}
     */
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatient();
    }

    /**
     * Récupère un patient spécifique à partir de son identifiant.
     *
     * @param id l'identifiant du patient
     * @return un {@link Optional} contenant le patient s'il existe
     */
    @GetMapping("/patients/{id}")
    public Optional<Patient> getOnePatient(@PathVariable Integer id) {
        return patientService.getOnePatient(id);
    }

    /**
     * Ajoute un nouveau patient à la base de données.
     *
     * @param patient les informations du patient à ajouter
     * @return le patient ajouté
     */
    @PostMapping("/patients")
    public Patient addOnePatient(@Valid @RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    /**
     * Met à jour les informations d'un patient existant.
     *
     * @param patient les nouvelles informations du patient
     * @param id      l'identifiant du patient à mettre à jour
     */
    @PutMapping("/patients/{id}")
    public void updatePatient(@Valid @RequestBody Patient patient, @PathVariable Integer id) {
        patientService.updatePatient(id, patient);
    }

    /**
     * Supprime un patient de la base de données.
     *
     * @param id l'identifiant du patient à supprimer
     */
    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable Integer id) {
        patientService.deletePatient(id);
    }
}
