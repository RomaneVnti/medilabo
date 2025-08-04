package com.openclassrooms.risk.proxies;

import com.openclassrooms.risk.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Proxy Feign pour communiquer avec le microservice Patient.
 */
@FeignClient(name = "patient", url = "http://patient:8081")
public interface PatientProxy {

    /**
     * Récupère la liste de tous les patients.
     *
     * @return une liste d'objets PatientBean représentant les patients.
     */
    @GetMapping(value = "/api/patients")
    List<PatientBean> listDesPatients();

    /**
     * Récupère un patient en fonction de son identifiant.
     *
     * @param patId l'identifiant du patient
     * @return un objet PatientBean représentant le patient correspondant.
     */
    @GetMapping(value = "/api/patients/{patId}")
    PatientBean getOnePatient(@PathVariable Integer patId);

}
