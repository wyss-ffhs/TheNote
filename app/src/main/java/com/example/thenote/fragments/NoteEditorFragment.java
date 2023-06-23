package com.example.thenote.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thenote.R;
import com.example.thenote.fragments.adapters.NoteImageAdapter;
import com.example.thenote.fragments.viewmodels.NoteEditorViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteEditorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteEditorFragment extends Fragment {

    private NoteImageAdapter mImageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_editor, container, false);
        EditText mNoteText = view.findViewById(R.id.editText_note);
        Button mCameraButton = view.findViewById(R.id.button_camera);
        ImageView mImageView = view.findViewById(R.id.imageView_note);

        mCameraButton.setOnClickListener(v -> {
            // Implement the logic for capturing a visual note using the camera
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_images);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        mImageAdapter = new NoteImageAdapter(requireContext());
        recyclerView.setAdapter(mImageAdapter);

        NoteEditorViewModel mViewModel = new ViewModelProvider(requireActivity()).get(NoteEditorViewModel.class);
        mViewModel.getImagesLiveData().observe(getViewLifecycleOwner(), noteImages -> mImageAdapter.setImages(noteImages));

        return view;
    }

    // Implement other methods for saving the note, capturing audio notes, etc.
}