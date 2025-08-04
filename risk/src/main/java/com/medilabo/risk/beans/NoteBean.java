package com.openclassrooms.risk.beans;

import lombok.Data;

/**
 * Bean représentant une note associée à un patient.
 * <p>
 * Contient l'identifiant du patient, le nom du patient, et le contenu de la note.
 * </p>
 */
@Data
public class NoteBean {

    /**
     * Identifiant du patient.
     */
    private Integer patId;

    /**
     * Nom du patient.
     */
    private String patient;

    /**
     * Contenu de la note.
     */
    private String note;
}
