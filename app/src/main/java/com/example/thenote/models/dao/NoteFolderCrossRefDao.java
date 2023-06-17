package com.example.thenote.models.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.thenote.models.cross_refs.NoteFolderCrossRef;

@Dao
public interface NoteFolderCrossRefDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(NoteFolderCrossRef crossRef);

    @Query("DELETE FROM notefoldercrossref WHERE noteId = :noteId")
    void deleteByNoteId(int noteId);

    // Weitere Methoden hier
}
