package com.example.thenote.activities;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NavUtils;
import androidx.preference.PreferenceManager;

import com.example.thenote.R;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_ENABLE_NOTIFICATION = "enable_notification";
    private static final String KEY_DARK_MODE = "dark_mode";
    public static SharedPreferences sharedPreferences;

    public static void saveEnableNotificationSetting(boolean isEnabled) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_ENABLE_NOTIFICATION, isEnabled);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        setContentView(R.layout.activity_main);
        Button settingsButton = findViewById(R.id.button_settings);
        settingsButton.setOnClickListener(v -> openSettings());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        applyDarkMode();
        applyEnableNotifications();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (getParentActivityIntent() == null) {
                Log.i(TAG, "You have forgotten to specify the parentActivityName in the AndroidManifest!");
                onBackPressed();
            } else {
                NavUtils.navigateUpFromSameTask(this);
            }
            return true;
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

