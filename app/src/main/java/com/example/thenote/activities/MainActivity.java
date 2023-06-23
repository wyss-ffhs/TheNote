package com.example.thenote.activities;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import com.example.thenote.R;
import com.example.thenote.fragments.NoteEditorFragment;
import com.example.thenote.fragments.NoteOrganizerFragment;
import com.example.thenote.fragments.NoteViewerFragment;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_ENABLE_NOTIFICATION = "enable_notification";
    private static final String KEY_DARK_MODE = "dark_mode";
    public static SharedPreferences sharedPreferences;
    private Button editorButton;
    private Button editorOrganizer;
    private Button editorViewer;
    public static void saveEnableNotificationSetting(boolean isEnabled) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_ENABLE_NOTIFICATION, isEnabled);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Back button
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        setContentView(R.layout.activity_main);
//
        // Standardfragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, new NoteViewerFragment())
                    .commit();
        }
        //
        editorButton = findViewById(R.id.button_editor);
        editorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNoteEditorFragment();
            }
        });
        editorOrganizer = findViewById(R.id.button_organizer);
        editorOrganizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNoteOrganizerFragment();
            }
        });
        editorViewer = findViewById(R.id.button_viewer);
        editorViewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNoteViewerFragment();
            }
        });
        //
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        applyDarkMode();
        applyEnableNotifications();
        //
        // assigning ID of the toolbar to a variable
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);
    }

    private void openNoteViewerFragment() {
        Fragment noteViewerFragment = new NoteViewerFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, noteViewerFragment);
        fragmentTransaction.addToBackStack(null); // Optional, um den vorherigen Fragment-Status beizubehalten
        fragmentTransaction.commit();
    }

    private void openNoteOrganizerFragment() {
        Fragment noteOrganizerFragment = new NoteOrganizerFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, noteOrganizerFragment);
        fragmentTransaction.addToBackStack(null); // Optional, um den vorherigen Fragment-Status beizubehalten
        fragmentTransaction.commit();
    }

    private void openNoteEditorFragment() {
        Fragment noteEditorFragment = new NoteEditorFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, noteEditorFragment);
        fragmentTransaction.addToBackStack(null); // Optional, um den vorherigen Fragment-Status beizubehalten
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id== android.R.id.home) {
            if (getParentActivityIntent() == null) {
                Log.i(TAG, "You have forgotten to specify the parentActivityName in the AndroidManifest!");
                onBackPressed();
            } else {
                NavUtils.navigateUpFromSameTask(this);
            }
            return true;
        }
        if (id == R.id.action_settings) {
            openSettings();
        }

        return super.onOptionsItemSelected(item);
    }

    private void applyEnableNotifications() {
        boolean isDarkModeEnabled = sharedPreferences.getBoolean("enable_notifications", false);
        saveEnableNotificationSetting(isDarkModeEnabled);
    }

    private void applyDarkMode() {
        boolean isDarkModeEnabled = sharedPreferences.getBoolean("dark_mode", false);
        if (isDarkModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private void openSettings() {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    private boolean getEnableNotificationSetting() {
        return sharedPreferences.getBoolean(KEY_ENABLE_NOTIFICATION, false);
    }

}

