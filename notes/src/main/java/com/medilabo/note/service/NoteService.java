package com.openclassrooms.note.service;

import com.openclassrooms.note.model.Note;
import com.openclassrooms.note.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

/**
 * Implémentation de l'interface {@link INoteService} qui fournit
 * les opérations métier pour la gestion des notes.
 */
@Service
public class NoteService implements INoteService {

    /**
     * Logger pour afficher des messages dans la console ou les fichiers de log.
     */
    private static final Logger logger = Logger.getLogger(NoteService.class.getName());

    /**
     * Dépendance injectée automatiquement pour interagir avec la base de données MongoDB.
     */
    @Autowired
    private NoteRepository noteRepository;

    /**
     * {@inheritDoc}
     * Récupère toutes les notes enregistrées dans la base de données.
     *
     * @return liste de toutes les {@link Note}
     */
    @Override
    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }

    /**
     * {@inheritDoc}
     * Récupère uniquement les contenus textuels des notes associées à un patient spécifique.
     *
     * @param patId l'identifiant du patient
     * @return liste des notes sous forme de texte
     */
    @Override
    public List<String> getPatientNotes(Integer patId) {
        List<Note> allNotes = noteRepository.findAll();
        List<String> patientNotes = new ArrayList<>();

        for (Note notes : allNotes) {
            if (Objects.equals(notes.getPatId(), patId)) {
                patientNotes.add(notes.getNote());
            }
        }

        System.out.println(">>> Notes trouvées pour patient " + patId + " : " + patientNotes);
        return patientNotes;
    }

    /**
     * {@inheritDoc}
     * Ajoute une nouvelle note dans la base de données.
     *
     * @param note l'objet {@link Note} à sauvegarder
     * @return la note enregistrée
     */
    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }
}
