package com.example.thenote.models.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.thenote.database.NoteDatabase;
import com.example.thenote.models.Note;
import com.example.thenote.models.dao.NoteDao;

import java.util.List;

public class NoteRepository {
    private final NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public void insert(Note note) {
        noteDao.insert(note);
    }

    public void update(Note note) {
        noteDao.update(note);
    }

    public void delete(Note note) {
        noteDao.delete(note);
    }

    public void searchNotes(String searchText) {
        allNotes = noteDao.searchNotes(searchText);
    }

    public void moveNoteToFolder(Note note, String folder) {
    }

    public void importNotes() {
    }

    public void exportNotes() {
    }

    public void archiveNotes() {
    }
}
