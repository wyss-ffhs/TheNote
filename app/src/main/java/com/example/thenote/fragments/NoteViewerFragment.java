package com.example.thenote.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thenote.R;
import com.example.thenote.fragments.adapters.NoteAdapter;
import com.example.thenote.fragments.viewmodels.NoteViewModel;
import com.example.thenote.models.Note;

import java.util.List;

public class NoteViewerFragment extends Fragment implements  NoteAdapter.NoteClickListener{

    private NoteViewModel mNoteViewModel;
    private NoteAdapter mNoteAdapter;
    private EditText mSearchEditText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_viewer, container, false);

        mSearchEditText = view.findViewById(R.id.editTextSearch);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNoteAdapter = new NoteAdapter();
        recyclerView.setAdapter(mNoteAdapter);

        mNoteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        mNoteViewModel.getAllNotes().observe(getViewLifecycleOwner(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                mNoteAdapter.setNotes(notes);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSearchEditText.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                String searchText = mSearchEditText.getText().toString().trim();
                mNoteViewModel.searchNotes(searchText);
                return true;
            }
            return false;
        });
    }
    @Override
    public void onNoteClick(Note note) {
        // Aktion ausführen, wenn eine Notiz angeklickt wird
        Toast.makeText(requireContext(), "Notiz geklickt: " + note.getTitle(), Toast.LENGTH_SHORT).show();
    }

}