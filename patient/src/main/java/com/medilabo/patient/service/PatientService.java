package com.medilabo.patient.service;

import com.medilabo.patient.model.Patient;
import com.medilabo.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PatientService implements IPatientService {

    private static final Logger logger = Logger.getLogger(PatientService.class.getName());

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getOnePatient(Integer id){
        return patientRepository.findById(id);
    }

    @Override
    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

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
