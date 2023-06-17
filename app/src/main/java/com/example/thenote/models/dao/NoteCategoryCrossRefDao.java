package com.example.thenote.models.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.thenote.models.cross_refs.NoteCategoryCrossRef;

@Dao
public interface NoteCategoryCrossRefDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(NoteCategoryCrossRef crossRef);

    @Query("DELETE FROM notecategorycrossref WHERE noteId = :noteId")
    void deleteByNoteId(int noteId);

    // Weitere Methoden hier
}
