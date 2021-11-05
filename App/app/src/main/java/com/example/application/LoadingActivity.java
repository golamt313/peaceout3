package com.example.application;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingActivity extends AppCompatActivity {
    private TextView tv ;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        tv = (TextView) findViewById(R.id.tv) ;
        iv = (ImageView) findViewById(R.id.iv) ;
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(anim);
        iv.startAnimation(anim);
        final Intent i = new Intent(this, LoginActivity.class);
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
        timer.start();

    }


}