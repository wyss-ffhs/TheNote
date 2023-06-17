package com.example.thenote.models.cross_refs;

import androidx.room.Entity;

@Entity(primaryKeys = {"noteId", "labelId"})
public class NoteLabelCrossRef {
    private int noteId;
    private int labelId;

    public NoteLabelCrossRef(int noteId, int labelId) {
        this.noteId = noteId;
        this.labelId = labelId;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }
}
