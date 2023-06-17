package com.example.thenote.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories")
public class Category {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    // Konstruktor, Getter und Setter hier

    // Weitere Methoden hier
}
