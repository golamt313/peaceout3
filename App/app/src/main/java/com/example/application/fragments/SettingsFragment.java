package com.example.application.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.MenuItem;

import com.example.application.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class SettingsFragment extends AppCompatActivity {


    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_settings);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.ic_settings);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_dashboard:
                        startActivity(new Intent(getApplicationContext(), DashboardFragment.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.ic_calendar:
                        startActivity(new Intent(getApplicationContext(), CalendarFragment.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.ic_settings:
                        return true;

                }
                return false;
            }
        });
    }
    public void preference(View view) {
        startActivity(new Intent(SettingsFragment.this, Preference.class));
        finish();
    }
    public void account(View view) {
        startActivity(new Intent(SettingsFragment.this, Account.class));
        finish();
    }
    public void profile(View view) {
        startActivity(new Intent(SettingsFragment.this, Profile.class));
        finish();
    }
}
