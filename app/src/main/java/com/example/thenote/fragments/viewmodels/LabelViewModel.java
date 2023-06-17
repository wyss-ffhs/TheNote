package com.example.thenote.fragments.viewmodels;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.thenote.models.Label;
import com.example.thenote.models.repositories.LabelRepository;

import java.io.Closeable;
import java.util.List;

public class LabelViewModel extends ViewModel {

    private LabelRepository labelRepository;
    private LiveData<List<Label>> allLabels;

    public LabelViewModel(Application application) {
        super((Closeable) application);
        labelRepository = new LabelRepository(application);
        allLabels = labelRepository.getAllLabels();
    }

    public void insertLabel(Label label) {
        labelRepository.insertLabel(label);
    }

    public void updateLabel(Label label) {
        labelRepository.updateLabel(label);
    }

    public void deleteLabel(Label label) {
        labelRepository.deleteLabel(label);
    }

    public LiveData<List<Label>> getAllLabels() {
        return allLabels;
    }
}
