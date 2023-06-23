package com.example.thenote.fragments.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thenote.R;
import com.example.thenote.models.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteOrganizerAdapter extends RecyclerView.Adapter<NoteOrganizerAdapter.FolderViewHolder> {

    private List<String> mFolders= new ArrayList<>();
    private OnFolderClickListener mClickListener;

    public NoteOrganizerAdapter(List<String> folders, OnFolderClickListener clickListener) {
        mFolders = folders;
        mClickListener = clickListener;
    }

    public NoteOrganizerAdapter() {

    }

    @NonNull
    @Override
    public FolderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_folder, parent, false);
        return new FolderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FolderViewHolder holder, int position) {
        String folder = mFolders.get(position);
        holder.bind(folder);
    }

    @Override
    public int getItemCount() {
        return mFolders.size();
    }

    public void setNotes(List<Note> notes) {
    }

    public interface OnFolderClickListener {
        void onFolderClick(String folder);
    }

    public class FolderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mFolderName;

        public FolderViewHolder(@NonNull View itemView) {
            super(itemView);
            mFolderName = itemView.findViewById(R.id.textFolder_name);
            itemView.setOnClickListener(this);
        }

        public void bind(String folder) {
            mFolderName.setText(folder);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                String folder = mFolders.get(position);
                mClickListener.onFolderClick(folder);
            }
        }
    }
}

