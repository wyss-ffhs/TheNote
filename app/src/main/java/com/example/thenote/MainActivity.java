package com.example.thenote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import com.example.thenote.activities.SettingsActivity;
import com.example.thenote.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    public static SharedPreferences sharedPreferences;
    private static final String KEY_ENABLE_NOTIFICATION = "enable_notification";
    private static final String KEY_DARK_MODE = "dark_mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button settingsButton = findViewById(R.id.button_settings);
        settingsButton.setOnClickListener(v -> openSettings());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        applyDarkMode();
        applyEnableNotifications();
    }

    private void applyEnableNotifications() {
        boolean isDarkModeEnabled = sharedPreferences.getBoolean("enable_notifications", false);
        if (isDarkModeEnabled) {
            saveEnableNotificationSetting(true);
        } else {
            saveEnableNotificationSetting(false);
        }
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

    public static void saveEnableNotificationSetting(boolean isEnabled) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_ENABLE_NOTIFICATION, isEnabled);
        editor.apply();
    }

    private boolean getEnableNotificationSetting() {
        return sharedPreferences.getBoolean(KEY_ENABLE_NOTIFICATION, false);
    }

}

