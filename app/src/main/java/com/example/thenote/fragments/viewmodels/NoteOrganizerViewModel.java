package com.example.thenote.fragments.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.thenote.models.Note;
import com.example.thenote.models.repositories.NoteRepository;

import java.util.List;

public class NoteOrganizerViewModel extends ViewModel {

    private final NoteRepository mNoteRepository;
    private final LiveData<List<Note>> mNotes;

    public NoteOrganizerViewModel(NoteRepository noteRepository) {
        mNoteRepository = noteRepository;
        mNotes = mNoteRepository.getAllNotes();
    }

    public LiveData<List<Note>> getNotes() {
        return mNotes;
    }

    public void moveNoteToFolder(Note note, String folder) {
        // Implement the logic to move the note to the specified folder
        mNoteRepository.moveNoteToFolder(note, folder);
    }

    public void importNotes() {
        // Implement the logic to import notes
        mNoteRepository.importNotes();
    }

    public void exportNotes() {
        // Implement the logic to export notes
        mNoteRepository.exportNotes();
    }

    public void archiveNotes() {
        // Implement the logic to archive notes
        mNoteRepository.archiveNotes();
    }
}

