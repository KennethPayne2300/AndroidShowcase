package com.example.showcaseapp;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;

public class CreditsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}