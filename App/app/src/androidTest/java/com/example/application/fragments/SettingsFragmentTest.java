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

public class SettingsFragmentTest {
    @Test
    public void TestS_Calendar()
    {

        try(ActivityScenario<SettingsFragment> Setting_ActivityScenario = ActivityScenario.launch(SettingsFragment.class)) {
            onView(withId(R.id.ic_calendar)).perform(click());
            assertEquals(Setting_ActivityScenario.getState(), Lifecycle.State.CREATED);
        }

    }
    @Test
    public void TestS_DashboardCreated()
    {
        try(ActivityScenario<SettingsFragment> Setting_ActivityScenario = ActivityScenario.launch(SettingsFragment.class)) {
            onView(withId(R.id.ic_dashboard)).perform(click());
            assertEquals(Setting_ActivityScenario.getState(), Lifecycle.State.CREATED);
        }

    }

    @Test
    public void TestS_BringItTogether()
    {
        try(ActivityScenario<SettingsFragment> Setting_ActivityScenario = ActivityScenario.launch(SettingsFragment.class)) {
            onView(withId(R.id.ic_calendar)).perform(click());
            assertEquals(Setting_ActivityScenario.getState(), Lifecycle.State.CREATED);
            onView(withId(R.id.ic_dashboard)).perform(click());
            assertEquals(Setting_ActivityScenario.getState(), Lifecycle.State.CREATED);

        }

    }

}