package com.openclassrooms.risk.service;

import com.openclassrooms.risk.beans.NoteBean;
import com.openclassrooms.risk.beans.PatientBean;
import com.openclassrooms.risk.model.Risk;
import com.openclassrooms.risk.proxies.NoteProxy;
import com.openclassrooms.risk.proxies.PatientProxy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Service pour évaluer le niveau de risque d'un patient.
 */
@Service
public class RiskService {

    private final PatientProxy patientProxy;
    private final NoteProxy noteProxy;

    /**
     * Constructeur avec injection des proxies Patient et Note.
     *
     * @param patientProxy proxy pour accéder aux données patients
     * @param noteProxy proxy pour accéder aux notes des patients
     */
    public RiskService(PatientProxy patientProxy, NoteProxy noteProxy) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
    }

    /**
     * Calcule le niveau de risque d'un patient en fonction de ses notes et de ses informations.
     *
     * @param patId l'identifiant du patient
     * @return une liste contenant l'objet Risk correspondant au patient
     */
    public List<Risk> setRiskLevel(Integer patId) {
        PatientBean patient = patientProxy.getOnePatient(patId);
        List<Risk> listAllRisk = new ArrayList<>();

        Risk risk = new Risk();
        risk.setPatId(patient.getPatientListId());

        LocalDate birthdate = patient.getBirthdate();
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthdate, currentDate).getYears();
        risk.setAge(age);

        List<String> patientNote = noteProxy.listDesNotes(patId);

        String[] triggerWords = {"Poids", "Taille", "Anticorps", "Cholestérol", "Réaction", "Rechute", "Anormal",
                "Hémoglobine A1C", "Microalbumine", "Fumeur", "Fumeuse", "Vertiges"};

        int triggerCount = 0;
        for (String note : patientNote) {
            for (String word : triggerWords) {
                if (note.toLowerCase().contains(word.toLowerCase())) {
                    triggerCount++;
                }
            }
        }
        risk.setTrigger(triggerCount);

        String gender = patient.getGender();

        if (triggerCount == 0) {
            risk.setRisk("None");
        } else {
            if (age > 30) {
                if (triggerCount >= 8) {
                    risk.setRisk("Early onset");
                } else if (triggerCount >= 6) {
                    risk.setRisk("In Danger");
                } else if (triggerCount >= 2) {
                    risk.setRisk("Borderline");
                } else {
                    risk.setRisk("None");
                }
            } else {
                switch (gender) {
                    case "M" -> {
                        if (triggerCount >= 5) {
                            risk.setRisk("Early onset");
                        } else if (triggerCount >= 3) {
                            risk.setRisk("In Danger");
                        } else {
                            risk.setRisk("None");
                        }
                    }
                    case "F", "Other" -> {
                        if (triggerCount >= 7) {
                            risk.setRisk("Early onset");
                        } else if (triggerCount >= 4) {
                            risk.setRisk("In Danger");
                        } else {
                            risk.setRisk("None");
                        }
                    }
                    default -> risk.setRisk("None");
                }
            }
        }

        listAllRisk.add(risk);

        return listAllRisk;
    }
}