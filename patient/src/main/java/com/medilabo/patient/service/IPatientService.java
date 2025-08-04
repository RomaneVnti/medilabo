package com.medilabo.patient.service;

import com.medilabo.patient.model.Patient;

import java.util.List;
import java.util.Optional;

/**
 * Interface définissant les opérations de service pour la gestion des patients.
 * <p>
 * Elle déclare les méthodes nécessaires à la manipulation des entités {@link Patient},
 * notamment la récupération, l'ajout, la mise à jour et la suppression.
 * </p>
 */
public interface IPatientService {

    /**
     * Récupère la liste de tous les patients.
     *
     * @return une liste d'objets {@link Patient}
     */
    List<Patient> getAllPatient();

    /**
     * Récupère un patient spécifique à partir de son identifiant.
     *
     * @param id l'identifiant du patient
     * @return un {@link Optional} contenant le patient s'il existe, ou vide sinon
     */
    Optional<Patient> getOnePatient(Integer id);

    /**
     * Ajoute un nouveau patient dans la base de données.
     *
     * @param patient l'objet {@link Patient} à ajouter
     * @return l'objet {@link Patient} enregistré
     */
    Patient addPatient(Patient patient);

    /**
     * Met à jour les informations d'un patient existant.
     *
     * @param id l'identifiant du patient à mettre à jour
     * @param patient les nouvelles informations du patient
     */
    void updatePatient(Integer id, Patient patient);

    /**
     * Supprime un patient de la base de données à partir de son identifiant.
     *
     * @param id l'identifiant du patient à supprimer
     */
    void deletePatient(Integer id);
}
