package com.openclassrooms.risk.model;

import lombok.Data;

/**
 * Modèle représentant le niveau de risque d'un patient.
 */
@Data
public class Risk {

    /**
     * Identifiant du patient.
     */
    private Integer patId;

    /**
     * Âge du patient.
     */
    private Integer age;

    /**
     * Nombre de déclencheurs (facteurs de risque) associés au patient.
     */
    private Integer trigger;

    /**
     * Niveau de risque évalué sous forme de chaîne de caractères.
     */
    private String risk;
}
