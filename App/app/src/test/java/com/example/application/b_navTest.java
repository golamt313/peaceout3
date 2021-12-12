package com.example.application;

import static org.junit.Assert.*;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.application.fragments.DashboardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class, sdk=21)
public class b_navTest {
    //public b_nav activity ;
    @Mock
    public Context mockcontext;
    public BottomNavigationView mockBNV;
    public b_nav activity ;


    @Rule
    public TestRule rule = new InstantTaskExecutorRule();
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        activity = new b_nav();
    }

    @After
    public void tearDown() throws Exception {
        activity = null;
    }
    @Test
    public void Test1(){
        b_nav testactivity = Robolectric.setupActivity(b_nav.class);
        Assert.assertNotNull(testactivity);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) testactivity.findViewById(R.id.bottom_navigation);
        Assert.assertNotNull(bottomNavigationView);
        Assert.assertEquals(View.VISIBLE, bottomNavigationView.getVisibility());
        bottomNavigationView.setSelectedItemId(R.id.ic_dashboard);
        Assert.assertNotNull(bottomNavigationView.getSelectedItemId());
        //copied test from mainActivity
        Assert.assertTrue(true);
        Assert.assertNotNull(activity);
        Intent expectedIntent = new Intent(activity, DashboardFragment.class);
        //Mockito.when(activity.onCreate());
        Assert.assertNotNull(expectedIntent);


    }
}