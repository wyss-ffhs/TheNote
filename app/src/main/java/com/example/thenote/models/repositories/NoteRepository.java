package com.example.thenote.models.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.thenote.database.NoteDatabase;
import com.example.thenote.models.Note;
import com.example.thenote.models.dao.NoteDao;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
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
        // Führe die Einfügeoperation in der Datenbank aus (z. B. über noteDao)
        // Hier solltest du die asynchrone Einfügeoperation verwenden, um das Haupt-Thread-Blocking zu vermeiden
        // Beispiel: noteDao.insert(note);
    }

    public void update(Note note) {
        // Führe die Aktualisierungsoperation in der Datenbank aus (z. B. über noteDao)
        // Beispiel: noteDao.update(note);
    }

    public void delete(Note note) {
        // Führe die Löschoperation in der Datenbank aus (z. B. über noteDao)
        // Beispiel: noteDao.delete(note);
    }
}
