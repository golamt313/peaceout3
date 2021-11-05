package com.example.application;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< Updated upstream:App/app/src/main/java/com/example/application/LoadingActivity.java
public class LoadingActivity extends AppCompatActivity {
=======
public class MainActivity extends AppCompatActivity {
>>>>>>> Stashed changes:App/app/src/main/java/com/example/application/MainActivity.java
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
<<<<<<< Updated upstream:App/app/src/main/java/com/example/application/LoadingActivity.java
        final Intent i = new Intent(this, LoginActivity.class);
=======
        final Intent intent = new Intent(this, LoginActivity.class);
>>>>>>> Stashed changes:App/app/src/main/java/com/example/application/MainActivity.java
        Thread timer =new Thread(){
            public void run () {
                try {
                    sleep(5000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();

    }


}