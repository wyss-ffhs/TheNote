package com.example.thenote.fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thenote.R;
import com.example.thenote.fragments.adapters.NoteAdapter;
import com.example.thenote.fragments.viewmodels.NoteViewModel;
import com.example.thenote.models.Note;

import java.util.List;

public class NoteViewerFragment extends Fragment {

    public static NoteViewerFragment newInstance() {
        return new NoteViewerFragment();
    }

    private RecyclerView recyclerView;
    private NoteAdapter noteAdapter;
    private NoteViewModel noteViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NoteViewModel mViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_viewer, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        noteAdapter = new NoteAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(noteAdapter);

        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(getViewLifecycleOwner(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                noteAdapter.setNotes(notes);
            }
        });
    }

}