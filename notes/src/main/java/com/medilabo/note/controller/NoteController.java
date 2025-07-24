package com.openclassrooms.note.controller;

import com.openclassrooms.note.model.Note;
import com.openclassrooms.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteService.getAllNote();
    }
    @GetMapping("/notes/{patId}")
    public List<String> getPatientNotes(@PathVariable Integer patId){
        return noteService.getPatientNotes(patId);
    }
    @PostMapping("/notes")
    public Note addNote(@RequestBody Note note){
        return noteService.addNote(note);
    }

}