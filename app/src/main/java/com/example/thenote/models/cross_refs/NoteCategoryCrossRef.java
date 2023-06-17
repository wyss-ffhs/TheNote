package com.example.thenote.models.cross_refs;

import androidx.room.Entity;

@Entity(primaryKeys = {"noteId", "categoryId"})
public class NoteCategoryCrossRef {
    private int noteId;
    private int categoryId;

    // Konstruktor, Getter und Setter hier

    // Weitere Methoden hier
}
