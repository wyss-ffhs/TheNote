package com.example.thenote.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;

import com.example.thenote.MainActivity;
import com.example.thenote.R;

public class SettingsFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
        MainActivity.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());

        SwitchPreference enableNotificationPreference = findPreference("pref_key_enable_notifications");
        enableNotificationPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                MainActivity.sharedPreferences.edit()
                        .putBoolean("enable_notifications", (boolean) newValue)
                        .apply();
                MainActivity.saveEnableNotificationSetting((boolean) newValue);
                return true;
            }
        });

        SwitchPreference darkModePreference = findPreference("pref_key_dark_mode");
        darkModePreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                MainActivity.sharedPreferences.edit()
                        .putBoolean("dark_mode", (boolean) newValue)
                        .apply();
                return true;
            }
        });


}


}