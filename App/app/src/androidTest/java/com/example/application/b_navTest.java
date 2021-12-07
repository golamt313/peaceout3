package com.example.application;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;

@RunWith()
import android.content.Context;
import android.content.Intent;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.application.fragments.CalendarFragment;
import com.example.application.fragments.DashboardFragment;
import com.example.application.fragments.SettingsFragment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class b_navTest {
    @Mock b_nav test;
    public Context mockcontext;
    //test.startActivity(new Intent(test.getApplicationContext(), DashboardFragment.class));

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();
    public MockitoRule rule2= MockitoJUnit.rule();
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
       test = new b_nav();


    }

    @After
    public void tearDown() throws Exception {
        test = null;
    }
    @Test
    public void Test()
    {
        Intent intentD = new Intent(test, DashboardFragment.class);
        Assert.assertNotNull(intentD);
        ArgumentCaptor<Intent> argument = ArgumentCaptor.forClass(Intent.class);

       //Mockito.verify(mockcontext,test.startActivity(new Intent(test, DashboardFragment.class)));

        test.startActivity(intentD);
        ;
        test.startActivity(new Intent(test, CalendarFragment.class));
        test.startActivity(new Intent(test, SettingsFragment.class));
        Assert.assertNotNull(test);



    }
}