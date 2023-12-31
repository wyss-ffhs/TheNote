package com.example.thenote.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thenote.R;
import com.example.thenote.fragments.adapters.NoteOrganizerAdapter;
import com.example.thenote.fragments.viewmodels.NoteOrganizerViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class NoteOrganizerFragment extends Fragment {

    private NoteOrganizerAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_organizer, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_folders);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mAdapter = new NoteOrganizerAdapter();
        recyclerView.setAdapter(mAdapter);

        NoteOrganizerViewModel mViewModel = new ViewModelProvider(requireActivity()).get(NoteOrganizerViewModel.class);
        mViewModel.getNotes().observe(getViewLifecycleOwner(), notes -> mAdapter.setNotes(notes));

        return view;
    }

}