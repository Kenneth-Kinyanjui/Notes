package com.secure.notes.services;

import com.secure.notes.models.Note;
import com.secure.notes.repositories.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepo noteRepo;

    @Override
    public Note createNoteForUser(String username, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        Note savedNote = noteRepo.save(note);
        return savedNote;
    }

    @Override
    public Note updateNoteForUser(Long noteId, String content, String username) {
        Note note = noteRepo.findById(noteId).orElseThrow(()
                -> new RuntimeException("Note not found"));
        note.setContent(content);
        Note updatedNote = noteRepo.save(note);
        return updatedNote;

    }
    @Override
    public void deleteNoteForUser(Long noteId, String username) {
        noteRepo.deleteById(noteId);
    }


    @Override
    public List<Note> getNotesForUser(String username) {
        List<Note> personalNotes = noteRepo.findByOwnerUsername(username);
        return personalNotes;
    }
}
