package com.example.application;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.squareup.picasso.Picasso;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        final ImageView image = findViewById(R.id.photoUrl);
        final TextView email = findViewById(R.id.emailId);
        final TextView fullName = findViewById(R.id.fullName);
        final AppCompatButton signOutBtn = findViewById(R.id.signOutBtn);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);
        // get details for signed in user
        if(googleSignInAccount != null) {
            final String getFullName = googleSignInAccount.getDisplayName();
            final String getEmail = googleSignInAccount.getEmail();
            final Uri getPhotoUrl = googleSignInAccount.getPhotoUrl();
            email.setText("Email : " + getEmail);
            fullName.setText("FullName : " + getFullName);
            Picasso.get().load(getPhotoUrl).into(image);
        }

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                googleSignInClient.signOut();

                // opens Login to sign in again
                startActivity(new Intent(Home.this, Login.class));
                finish();
            }
        });

    }
}
