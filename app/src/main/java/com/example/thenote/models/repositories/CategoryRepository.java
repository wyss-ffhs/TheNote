package com.example.thenote.models.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.thenote.database.CategoryDatabase;
import com.example.thenote.models.Category;
import com.example.thenote.models.dao.CategoryDao;

import java.util.List;

public class CategoryRepository {

    private final CategoryDao categoryDao;
    private final LiveData<List<Category>> allCategories;

    public CategoryRepository(Application application) {
        CategoryDatabase database = CategoryDatabase.getInstance(application);
        categoryDao = database.categoryDao();
        allCategories = categoryDao.getAllCategories();
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }

    public void insertCategory(Category category) {
        categoryDao.insertCategory(category);
    }

    public void updateCategory(Category category) {
        categoryDao.update(category);
    }

    public void deleteCategory(Category category) {
        categoryDao.delete(category);
    }

}
