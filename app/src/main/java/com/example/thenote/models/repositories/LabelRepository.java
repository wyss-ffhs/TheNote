package com.example.thenote.models.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.thenote.database.LabelDatabase;
import com.example.thenote.models.Label;
import com.example.thenote.models.dao.LabelDao;

import java.util.List;

public class LabelRepository {

    private final LabelDao labelDao;
    private final LiveData<List<Label>> allLabels;

    public LabelRepository(Application application) {
        LabelDatabase database = LabelDatabase.getInstance(application);
        labelDao = database.labelDao();
        allLabels = labelDao.getAllLabels();
    }

    public LiveData<List<Label>> getAllLabels() {
        return allLabels;
    }

    public void insertLabel(Label label) {
        labelDao.insert(label);
    }

    public void updateLabel(Label label) {
        labelDao.update(label);
    }

    public void deleteLabel(Label label) {
        labelDao.delete(label);
    }


}

