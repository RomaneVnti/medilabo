package com.openclassrooms.risk.controller;

import com.openclassrooms.risk.model.Risk;
import com.openclassrooms.risk.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Contrôleur REST pour gérer les requêtes relatives aux risques des patients.
 */
@RestController
public class RiskController {

    /**
     * Service de gestion des risques injecté par Spring.
     */
    @Autowired
    private RiskService riskService;

    /**
     * Récupère la liste des risques associés à un patient donné.
     *
     * @param patId Identifiant du patient
     * @return Liste des objets Risk pour ce patient
     */
    @GetMapping("api/risks/{patId}")
    public List<Risk> getPatientsRisks(@PathVariable Integer patId){
        return riskService.setRiskLevel(patId);
    }
}
