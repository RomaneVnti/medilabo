package com.openclassrooms.note.service;

import com.openclassrooms.note.model.Note;

import java.util.List;

/**
 * Interface définissant les opérations de service liées aux entités {@link Note}.
 */
public interface INoteService {

    /**
     * Récupère la liste de toutes les notes disponibles.
     *
     * @return une liste de toutes les {@link Note}
     */
    List<Note> getAllNote();

    /**
     * Récupère les notes associées à un patient donné, identifiées par son identifiant.
     * Seul le texte des notes est retourné sous forme de liste de chaînes de caractères.
     *
     * @param patId l'identifiant du patient
     * @return une liste de chaînes représentant les notes du patient
     */
    List<String> getPatientNotes(Integer patId);

    /**
     * Ajoute une nouvelle note à la base de données.
     *
     * @param note l'objet {@link Note} à ajouter
     * @return la {@link Note} ajoutée
     */
    Note addNote(Note note);
}
