package com.example.application.fragments;

import static com.example.application.fragments.CalendarUtils.daysInWeekArray;
import static com.example.application.fragments.CalendarUtils.monthYearFromDate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.application.Login;
import com.example.application.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;


public class DashboardFragment extends AppCompatActivity {
    private ListView eventListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);
        initWidgets();
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textViewDate = findViewById(R.id.todaydate);
        textViewDate.setText(currentDate);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.ic_dashboard);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_dashboard:
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

        final ImageView image = findViewById(R.id.photoUrl);
        //final TextView email = findViewById(R.id.emailId);
        final TextView fullName = findViewById(R.id.fullName);
        //final Button signOutBtn = findViewById(R.id.signOutBtn);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);
        // get details for signed in user
        if(googleSignInAccount != null) {
            final String getFullName = googleSignInAccount.getGivenName ();
            final String getEmail = googleSignInAccount.getEmail();
            final Uri getPhotoUrl = googleSignInAccount.getPhotoUrl();
            //email.setText("Email : " + getEmail);
            fullName.setText("Welcome " + getFullName);
            Picasso.get().load(getPhotoUrl).into(image);
        }

        //signOutBtn.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View v) {

            //    googleSignInClient.signOut();

                // opens Login to sign in again
              //  startActivity(new Intent(DashboardFragment.this, Login.class));
                //finish();
           // }
        //});

    }

    private void initWidgets()
    {
        eventListView = findViewById(R.id.eventListView);
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        setEventAdpater();
    }

    private void setEventAdpater() {
        ArrayList<Event> dailyEvents = Event.eventsForDate(LocalDate.now());
        int itemCount = dailyEvents.size();
        String str1 = Integer.toString(itemCount);
        TextView textViewevent = findViewById(R.id.numevent);
        textViewevent.setText(str1);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
        eventListView.setAdapter(eventAdapter);
        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(DashboardFragment.this,EventEditActivity.class));
            }
        });

    }


}
