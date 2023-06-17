package com.example.thenote.models.cross_refs;
import androidx.room.Entity;

@Entity(primaryKeys = {"noteId", "labelId"})
public class NoteLabelCrossRef {
    private int noteId;
    private int labelId;

    // Konstruktor, Getter und Setter hier

    // Weitere Methoden hier
}
