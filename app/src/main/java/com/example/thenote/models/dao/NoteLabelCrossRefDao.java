package com.example.thenote.models.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.thenote.models.cross_refs.NoteLabelCrossRef;

@Dao
public interface NoteLabelCrossRefDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(NoteLabelCrossRef crossRef);

    @Query("DELETE FROM notelabelcrossref WHERE noteId = :noteId")
    void deleteByNoteId(int noteId);

    // Weitere Methoden hier
}
