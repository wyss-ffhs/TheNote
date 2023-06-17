package com.example.thenote.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "labels")
public class Label {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    // Konstruktor, Getter und Setter hier

    // Weitere Methoden hier
}
