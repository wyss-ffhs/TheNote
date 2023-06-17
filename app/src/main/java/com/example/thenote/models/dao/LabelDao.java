package com.example.thenote.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.thenote.models.Label;

import java.util.List;

@Dao
public interface LabelDao {
    @Insert
    void insert(Label label);

    @Update
    void update(Label label);

    @Delete
    void delete(Label label);

    @Query("SELECT * FROM labels")
    LiveData<List<Label>> getAllLabels();

    // Weitere Methoden hier
}
