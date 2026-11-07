package org.example.notesservice.service;

import org.example.notesservice.entity.Note;
import org.example.notesservice.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // Save a new note
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    // Get all notes
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // Get note by ID
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Note not found with ID: " + id));
    }

    // Delete note
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
