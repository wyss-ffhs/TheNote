package com.example.thenote.models;

public class NoteImage {
    private String imageUrl;
    // Weitere Eigenschaften wie ID, Titel, Beschreibung, Datum usw. können hier hinzugefügt werden

    public NoteImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
