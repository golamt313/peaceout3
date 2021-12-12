package com.example.application.fragments;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import android.content.Intent;

import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;

import com.example.application.R;
import com.example.application.b_nav;

import org.junit.Test;
import org.mockito.Mockito;

public class CalendarFragmentTest {

    @Test
    public void Test_Weekly_Events()
    {

        try(ActivityScenario<b_nav> CalendarScenario = ActivityScenario.launch(b_nav.class)) {
            onView(withId(R.id.ic_calendar)).perform(click());
            onView(withText("Weekly")).perform(click());
            onView(withText("New Event")).perform(click());
            onView(withText("Save")).perform(click());
            assertEquals(CalendarScenario.getState(), Lifecycle.State.CREATED);
        }
    }
    @Test
    public void Test_NextMonth_Events()
    {

        try(ActivityScenario<b_nav> CalendarScenario = ActivityScenario.launch(b_nav.class)) {
            onView(withId(R.id.ic_calendar)).perform(click());
            onView(withText("->")).perform(click());
            assertEquals(CalendarScenario.getState(), Lifecycle.State.CREATED);
        }
    }
    @Test
    public void Test_PrevMonth_Events()
    {

        try(ActivityScenario<b_nav> CalendarScenario = ActivityScenario.launch(b_nav.class)) {
            onView(withId(R.id.ic_calendar)).perform(click());
            onView(withText("<-")).perform(click());
            assertEquals(CalendarScenario.getState(), Lifecycle.State.CREATED);
        }
    }
    @Test
    public void Test_Date_Events()
    {

        try(ActivityScenario<b_nav> CalendarScenario = ActivityScenario.launch(b_nav.class)) {
            onView(withId(R.id.ic_calendar)).perform(click());
            onView(withText("5")).perform(click());
            assertEquals(CalendarScenario.getState(), Lifecycle.State.CREATED);
        }
    }


    @Test
    public void TestC_DashboardCreated()
    {
        try(ActivityScenario<CalendarFragment> CalendarScenario = ActivityScenario.launch(CalendarFragment.class)) {
            onView(withId(R.id.ic_dashboard)).perform(click());
            assertEquals(CalendarScenario.getState(), Lifecycle.State.CREATED);
        }

    }
    @Test
    public void TestC_SettingsCreated()
    {
        try(ActivityScenario<CalendarFragment> b_navActivityScenario = ActivityScenario.launch(CalendarFragment.class)) {
            onView(withId(R.id.ic_settings)).perform(click());
            assertEquals(b_navActivityScenario.getState(), Lifecycle.State.CREATED);
        }

    }

    @Test
    public void TestC_BringItTogether()
    {
        try(ActivityScenario<CalendarFragment> CalendarScenario = ActivityScenario.launch(CalendarFragment.class)) {
            onView(withId(R.id.ic_settings)).perform(click());
            assertEquals(CalendarScenario.getState(), Lifecycle.State.CREATED);
            onView(withId(R.id.ic_dashboard)).perform(click());
            assertEquals(CalendarScenario.getState(), Lifecycle.State.CREATED);

        }

    }

}