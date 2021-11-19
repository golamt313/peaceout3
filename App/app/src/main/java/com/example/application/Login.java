package com.example.application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Button signInBtn = findViewById(R.id.signInBtn);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);

        // Checks if user is already signed in
        if(googleSignInAccount != null) {
            startActivity(new Intent(Login.this, b_nav.class));
            finish();
        }

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                // Getting signed in account after user selected an account from options
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                handleSignInTask(task);
            }
        });
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent signInIntent = googleSignInClient.getSignInIntent();

                activityResultLauncher.launch(signInIntent);
            }
        });
    }

    private void handleSignInTask(Task<GoogleSignInAccount> task) {

        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);

            // Getting account data
            final String getFullname = account.getDisplayName();
            final String getEmail = account.getEmail();
            final Uri getPhotoUrl = account.getPhotoUrl();
            // Opening Login
            startActivity(new Intent(Login.this, b_nav.class));
            finish();
        } catch (ApiException e) {
            e.printStackTrace();
            Toast.makeText(this,"Failed or Cancelled", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}

