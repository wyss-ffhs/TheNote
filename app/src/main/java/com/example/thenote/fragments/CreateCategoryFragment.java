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
import com.example.thenote.fragments.viewmodels.CategoryViewModel;
import com.example.thenote.models.Category;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CreateCategoryFragment extends Fragment {

    private EditText editTextCategoryName;

    private CategoryViewModel categoryViewModel;

    public CreateCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_category, container, false);

        editTextCategoryName = view.findViewById(R.id.editText_category_name);
        Button buttonCreate = view.findViewById(R.id.button_category_create);
        Button buttonCancel = view.findViewById(R.id.button_category_cancel);

        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        buttonCreate.setOnClickListener(v -> {
            String categoryName = editTextCategoryName.getText().toString().trim();
            if (!TextUtils.isEmpty(categoryName)) {
                Category category = new Category(categoryName);
                categoryViewModel.insertCategory(category);
                // Schließe das Fragment oder führe andere Aktionen aus
            } else {
                Toast.makeText(getContext(), "Category name cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });

        buttonCancel.setOnClickListener(v -> {
            // Schließe das Fragment oder führe andere Aktionen aus
        });

        return view;
    }
}
