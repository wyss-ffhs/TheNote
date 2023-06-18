package com.example.thenote.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.thenote.R;
import com.example.thenote.fragments.viewmodels.LabelViewModel;
import com.example.thenote.models.Label;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CreateLabelFragment extends Fragment {

    private EditText editTextLabelName;

    private LabelViewModel labelViewModel;

    public CreateLabelFragment() {
        // Erforderlicher leerer Konstruktor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_label, container, false);
        editTextLabelName = view.findViewById(R.id.editText_label_name);
        Button buttonSaveLabel = view.findViewById(R.id.button_label_save);

        labelViewModel = new ViewModelProvider(requireActivity()).get(LabelViewModel.class);

        buttonSaveLabel.setOnClickListener(v -> {
            String labelName = editTextLabelName.getText().toString().trim();
            if (!TextUtils.isEmpty(labelName)) {
                Label label = new Label(labelName);
                labelViewModel.insertLabel(label);
                Toast.makeText(requireContext(), "Label saved", Toast.LENGTH_SHORT).show();
                requireActivity().onBackPressed();
            } else {
                Toast.makeText(requireContext(), "Please enter a label name", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

