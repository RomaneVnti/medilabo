package com.openclassrooms.note.controller;

import com.openclassrooms.note.model.Note;
import com.openclassrooms.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations liées aux notes.
 * Permet de récupérer toutes les notes, les notes d'un patient spécifique,
 * et d'ajouter une nouvelle note.
 */
@RestController
public class NoteController {

    /**
     * Service métier pour gérer les notes.
     */
    @Autowired
    private NoteService noteService;

    /**
     * Récupère la liste de toutes les notes présentes.
     *
     * @return Liste de toutes les notes.
     */
    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteService.getAllNote();
    }

    /**
     * Récupère la liste des notes associées à un patient donné.
     *
     * @param patId Identifiant du patient dont on souhaite obtenir les notes.
     * @return Liste des notes (sous forme de chaînes de caractères) du patient.
     */
    @GetMapping("/notes/{patId}")
    public List<String> getPatientNotes(@PathVariable Integer patId){
        return noteService.getPatientNotes(patId);
    }

    /**
     * Ajoute une nouvelle note dans la base de données.
     *
     * @param note Objet Note à ajouter, reçu dans le corps de la requête HTTP.
     * @return La note ajoutée avec ses informations éventuellement mises à jour (ex: ID généré).
     */
    @PostMapping("/notes")
    public Note addNote(@RequestBody Note note){
        return noteService.addNote(note);
    }

}
