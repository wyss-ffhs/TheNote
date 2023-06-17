package com.example.thenote.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.thenote.models.Folder;

import java.util.List;

@Dao
public interface FolderDao {
    @Insert
    void insert(Folder folder);

    @Update
    void update(Folder folder);

    @Delete
    void delete(Folder folder);

    @Query("SELECT * FROM folders")
    LiveData<List<Folder>> getAllFolders();

    // Weitere Methoden hier
}
