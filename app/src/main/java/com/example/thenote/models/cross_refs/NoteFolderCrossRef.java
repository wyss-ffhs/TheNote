package com.example.thenote.models.cross_refs;

import androidx.room.Entity;

@Entity(primaryKeys = {"noteId", "folderId"})
public class NoteFolderCrossRef {
    private int noteId;
    private int folderId;

    // Konstruktor, Getter und Setter hier

    // Weitere Methoden hier
}
