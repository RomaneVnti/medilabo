package com.openclassrooms.note.service;

import com.openclassrooms.note.model.Note;
import com.openclassrooms.note.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class NoteService implements INoteService{
    private static final Logger logger = Logger.getLogger(NoteService.class.getName());
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAllNote(){
        return noteRepository.findAll();
    }
    @Override
    public List<String> getPatientNotes(Integer patId) {
        List<Note> allNotes = noteRepository.findAll();
        List<String> patientNotes = new ArrayList<>();

        for(Note notes : allNotes){
            if(Objects.equals(notes.getPatId(), patId)){
                patientNotes.add(notes.getNote());
            }
        }
        return patientNotes;
    }
    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

}