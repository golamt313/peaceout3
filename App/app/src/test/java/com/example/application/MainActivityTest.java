package com.example.application;

import android.content.Intent;
import android.os.Build;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.TestRule;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

//@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
//@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    public MainActivity activity ;
    //@Rule
    //this bypasses the main thread check,
    // and immediately runs any tasks on your test thread,
    // allowing for immediate and predictable calls and therefore assertions.
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();
    @Before
    public void setUp() {
        activity = new MainActivity();
       //activity = Robolectric.setupActivity(MainActivity.class);
    }

    @After
    public void tearDown() {
    activity = null;
    }
    @Test
    public void Test1(){
        Assert.assertTrue(true);
        Assert.assertNotNull(activity);
        Intent expectedIntent = new Intent(activity,Login.class);

        Assert.assertNotNull(expectedIntent);


    }
}