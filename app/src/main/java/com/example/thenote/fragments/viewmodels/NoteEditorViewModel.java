package com.example.thenote.fragments.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thenote.models.NoteImage;

import java.util.ArrayList;
import java.util.List;

public class NoteEditorViewModel extends ViewModel {

    private MutableLiveData<List<NoteImage>> mImagesLiveData = new MutableLiveData<>();

    public MutableLiveData<List<NoteImage>> getImagesLiveData() {
        return mImagesLiveData;
    }

    public void addImage(NoteImage image) {
        List<NoteImage> currentImages = mImagesLiveData.getValue();
        if (currentImages == null) {
            currentImages = new ArrayList<>();
        }
        currentImages.add(image);
        mImagesLiveData.setValue(currentImages);
    }

    public void removeImage(NoteImage image) {
        List<NoteImage> currentImages = mImagesLiveData.getValue();
        if (currentImages != null) {
            currentImages.remove(image);
            mImagesLiveData.setValue(currentImages);
        }
    }

    // Implement other methods for saving the note, handling audio notes, etc.
}
