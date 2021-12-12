package com.example.application.fragments;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import com.example.application.R;
import com.example.application.b_nav;

import org.junit.Test;

public class DashboardFragmentTest {
    @Test
    public void TestD_Calendar()
    {

        try(ActivityScenario<DashboardFragment> DashboardScenario = ActivityScenario.launch(DashboardFragment.class)) {
            onView(withId(R.id.ic_calendar)).perform(click());
            assertEquals(DashboardScenario.getState(), Lifecycle.State.CREATED);
        }

    }

    @Test
    public void TestD_SettingsCreated()
    {
        try(ActivityScenario<DashboardFragment> DashboardScenario = ActivityScenario.launch(DashboardFragment.class)) {
            onView(withId(R.id.ic_settings)).perform(click());
            assertEquals(DashboardScenario.getState(), Lifecycle.State.CREATED);
        }

    }

    @Test
    public void TestD_BringItTogether()
    {
        try(ActivityScenario<DashboardFragment> DashboardScenario = ActivityScenario.launch(DashboardFragment.class)) {
            onView(withId(R.id.ic_settings)).perform(click());
            assertEquals(DashboardScenario.getState(), Lifecycle.State.CREATED);
            onView(withId(R.id.ic_calendar)).perform(click());
            assertEquals(DashboardScenario.getState(), Lifecycle.State.CREATED);
        }

    }

}