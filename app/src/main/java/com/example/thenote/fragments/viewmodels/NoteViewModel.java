package com.example.thenote.fragments.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.thenote.models.Note;
import com.example.thenote.models.repositories.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private final NoteRepository noteRepository;
    private final LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        allNotes = noteRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public void searchNotes(String searchText) {
        noteRepository.searchNotes(searchText);
    }

    public void insert(Note note) {
        noteRepository.insertNote(note);
    }

    public void update(Note note) {
        noteRepository.updateNote(note);
    }

    public void delete(Note note) {
        noteRepository.deleteNote(note);
    }
}
