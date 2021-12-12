package com.example.application.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.application.Login;
import com.example.application.R;
import com.example.application.fragments.CalendarFragment;
import com.example.application.fragments.SettingsFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

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
                        startActivity(new Intent(getApplicationContext(), SettingsFragment.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
        final Button signOutBtn = findViewById(R.id.sout);
        final Button addAccountBtn = findViewById(R.id.auser);
        final Button switchUserBtn = findViewById(R.id.saccount);


        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);
        signOutBtn.setOnClickListener(new View.OnClickListener() {
          @Override
         public void onClick(View v) {

           googleSignInClient.signOut();

         //opens Login to sign in again
              startActivity(new Intent(Account.this, Login.class));
        finish();
         }
        });
        switchUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                googleSignInClient.signOut();
                googleSignInClient.getSignInIntent();
            }
        });

    }

    }
