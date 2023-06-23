package com.example.thenote.fragments.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.thenote.models.Note;
import com.example.thenote.models.repositories.NoteRepository;

import java.util.List;

public class NoteOrganizerViewModel extends AndroidViewModel {

    private final NoteRepository noteRepository;
    private final LiveData<List<Note>> allNotes;

    public NoteOrganizerViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        allNotes = noteRepository.getAllNotes();
    }

    public LiveData<List<Note>> getNotes() {
        return allNotes;
    }

    public void moveNoteToFolder(Note note, String folder) {
        // Implement the logic to move the note to the specified folder
        noteRepository.moveNoteToFolder(note, folder);
    }

    public void importNotes() {
        // Implement the logic to import notes
        noteRepository.importNotes();
    }

    public void exportNotes() {
        // Implement the logic to export notes
        noteRepository.exportNotes();
    }

    public void archiveNotes() {
        // Implement the logic to archive notes
        noteRepository.archiveNotes();
    }
}

