package com.medilabo.patient.service;

import com.medilabo.patient.model.Patient;
import com.medilabo.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Service d'implémentation des opérations sur les patients.
 * <p>
 * Cette classe fournit les méthodes pour récupérer, ajouter,
 * modifier et supprimer des patients via le {@link PatientRepository}.
 * </p>
 */
@Service
public class PatientService implements IPatientService {

    private static final Logger logger = Logger.getLogger(PatientService.class.getName());

    @Autowired
    private PatientRepository patientRepository;

    /**
     * Récupère la liste complète des patients.
     *
     * @return liste des patients
     */
    @Override
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    /**
     * Récupère un patient à partir de son identifiant.
     *
     * @param id identifiant du patient
     * @return un Optional contenant le patient s'il existe, sinon vide
     */
    @Override
    public Optional<Patient> getOnePatient(Integer id){
        return patientRepository.findById(id);
    }

    /**
     * Ajoute un nouveau patient en base de données.
     *
     * @param patient objet patient à ajouter
     * @return patient ajouté
     */
    @Override
    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    /**
     * Met à jour un patient existant identifié par son id.
     * Si le patient n'existe pas, une entrée de log est créée.
     *
     * @param id identifiant du patient à mettre à jour
     * @param patient nouvelles données du patient
     */
    @Override
    public void updatePatient(Integer id, Patient patient){
        Optional<Patient> patientData = patientRepository.findById(id);

        if(patientData.isPresent()){
            Patient patientUpdate = patientData.get();
            patientUpdate.setFirstName(patient.getFirstName());
            patientUpdate.setLastName(patient.getLastName());
            patientUpdate.setGender(patient.getGender());
            patientUpdate.setAddress(patient.getAddress());
            patientUpdate.setBirthdate(patient.getBirthdate());
            patientUpdate.setPhoneNumber(patient.getPhoneNumber());
            logger.info("Request update Patient successful");
            patientRepository.save(patientUpdate);
        } else {
            logger.info("Request update Patient failed: patient not found");
        }
    }

    /**
     * Supprime un patient existant par son identifiant.
     * Si le patient n'existe pas, une entrée de log est créée.
     *
     * @param id identifiant du patient à supprimer
     */
    @Override
    public void deletePatient(Integer id){
        if(getOnePatient(id).isPresent()){
            logger.info("Request delete Patient successful");
            patientRepository.deleteById(id);
        } else {
            logger.info("Request delete Patient failed: patient not found");
        }
    }
}
