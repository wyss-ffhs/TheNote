package com.example.thenote.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.thenote.models.Label;
import com.example.thenote.models.dao.LabelDao;

@Database(entities = {Label.class}, version = 1, exportSchema = false)
public abstract class LabelDatabase extends RoomDatabase {

    private static LabelDatabase instance;

    public static synchronized LabelDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            LabelDatabase.class, "label_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract LabelDao labelDao();
}
