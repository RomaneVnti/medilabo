package com.openclassrooms.note.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Représente une note médicale associée à un patient.
 * Cette entité est stockée dans la collection MongoDB "notes".
 */
@Document("notes")
@Data
public class Note {

    /**
     * Identifiant unique de la note dans la base MongoDB.
     * Ce champ est ignoré lors de la sérialisation JSON.
     */
    @Id
    @JsonIgnore
    private String id;

    /**
     * Identifiant du patient auquel cette note est associée.
     */
    private Integer patId;

    /**
     * Nom complet du patient concerné par la note.
     */
    private String patient;

    /**
     * Contenu textuel de la note médicale.
     */
    private String note;
}
