package com.example.thenote.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thenote.R;
import com.example.thenote.fragments.adapters.NoteOrganizerAdapter;
import com.example.thenote.fragments.viewmodels.NoteOrganizerViewModel;
import com.example.thenote.models.Note;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class NoteOrganizerFragment extends Fragment {

    private NoteOrganizerViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private NoteOrganizerAdapter mAdapter;

    public NoteOrganizerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_organizer, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerViewFolders);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new NoteOrganizerAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mRecyclerView.setAdapter(mAdapter);

        mViewModel = new ViewModelProvider(requireActivity()).get(NoteOrganizerViewModel.class);
        mViewModel.getNotes().observe(getViewLifecycleOwner(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                mAdapter.setNotes(notes);
            }
        });
    }
}