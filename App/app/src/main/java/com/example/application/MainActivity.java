package com.example.application;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.services.api.v1.impl.UserServiceApiImpl;
import com.services.api.v1.interf.UserServiceApiInter;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView tv ;
    private ImageView iv;
    private UserServiceApiInter api = new UserServiceApiImpl("https://dummy.restapiexample.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //I had to add this policy in order to get this to work wiht my api.
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv) ;
        iv = (ImageView) findViewById(R.id.iv) ;
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(anim);
        iv.startAnimation(anim);
        final Intent i = new Intent(this,Login.class);
        Thread timer =new Thread(){
            public void run () {
                try {
                    sleep(5000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };

        try {

            Log.d("DataClient", api.getUserAllUsers().getData().toString());
            } catch (IOException e) {

        }


        timer.start();

    }


}