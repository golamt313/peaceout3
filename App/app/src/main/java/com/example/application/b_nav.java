package com.example.application;

import androidx.annotation.NonNull;

import com.example.application.fragments.CalendarFragment;
import com.example.application.fragments.DashboardFragment;
import com.example.application.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class b_nav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_nav);

        startActivity(new Intent(getApplicationContext(), DashboardFragment.class));
        overridePendingTransition(0, 0);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.ic_dashboard);


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
                        startActivity(new Intent(getApplicationContext(), SettingsFragment.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
    }
    }

