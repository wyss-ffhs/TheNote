package com.example.thenote.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.thenote.R;
import com.example.thenote.fragments.adapters.NoteImageAdapter;
import com.example.thenote.fragments.viewmodels.NoteEditorViewModel;
import com.example.thenote.models.NoteImage;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteEditorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteEditorFragment extends Fragment {

    private NoteEditorViewModel mViewModel;
    private EditText mNoteText;
    private Button mCameraButton;
    private ImageView mImageView;
    private NoteImageAdapter mImageAdapter;

    public static NoteEditorFragment newInstance() {
        return new NoteEditorFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_editor, container, false);
        mNoteText = view.findViewById(R.id.editTextNote);
        mCameraButton = view.findViewById(R.id.buttonCamera);
        mImageView = view.findViewById(R.id.imageView);

        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the logic for capturing a visual note using the camera
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewImages);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        mImageAdapter = new NoteImageAdapter(requireContext());
        recyclerView.setAdapter(mImageAdapter);

        mViewModel = new ViewModelProvider(requireActivity()).get(NoteEditorViewModel.class);
        mViewModel.getImagesLiveData().observe(getViewLifecycleOwner(), new Observer<List<NoteImage>>() {
            @Override
            public void onChanged(List<NoteImage> noteImages) {
                mImageAdapter.setImages(noteImages);
            }
        });

        return view;
    }

    // Implement other methods for saving the note, capturing audio notes, etc.
}