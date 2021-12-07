package com.example.application;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;

/*
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
import org.mockito.junit.MockitoRule;*/

public class b_navTest {
    /*@Mock b_nav test;
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
    }*/
    @Test
    public void TestCalendar()
    {

        try(ActivityScenario<b_nav> b_navActivityScenario = ActivityScenario.launch(b_nav.class)) {
            onView(withId(R.id.ic_calendar)).perform(click());
            assertEquals(b_navActivityScenario.getState(), Lifecycle.State.CREATED);
        }

    }
    @Test
    public void TestDashboardCreated()
    {
        try(ActivityScenario<b_nav> b_navActivityScenario = ActivityScenario.launch(b_nav.class)) {
            onView(withId(R.id.ic_dashboard)).perform(click());
            assertEquals(b_navActivityScenario.getState(), Lifecycle.State.CREATED);
        }

    }
    @Test
    public void TestSettingsCreated()
    {
        try(ActivityScenario<b_nav> b_navActivityScenario = ActivityScenario.launch(b_nav.class)) {
            onView(withId(R.id.ic_settings)).perform(click());
            assertEquals(b_navActivityScenario.getState(), Lifecycle.State.CREATED);
        }

    }

    @Test
    public void TestBringItTogether()
    {
        try(ActivityScenario<b_nav> b_navActivityScenario = ActivityScenario.launch(b_nav.class)) {
            onView(withId(R.id.ic_settings)).perform(click());
            assertEquals(b_navActivityScenario.getState(), Lifecycle.State.CREATED);
            onView(withId(R.id.ic_calendar)).perform(click());
            assertEquals(b_navActivityScenario.getState(), Lifecycle.State.CREATED);
            onView(withId(R.id.ic_dashboard)).perform(click());
            assertEquals(b_navActivityScenario.getState(), Lifecycle.State.CREATED);

        }

    }
}