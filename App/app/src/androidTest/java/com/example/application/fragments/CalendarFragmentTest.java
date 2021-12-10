package com.example.application.fragments;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
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
    public void Test_Events()
    { CalendarFragment calendar = new CalendarFragment();
      Intent calendarInt = new Intent(calendar,WeekViewActivity.class);
      CalendarViewHolder viewHolder = mock(CalendarViewHolder.class);
      verify(viewHolder);
      //assertEquals(calendar.startNextMatchingActivity(calendarInt),EventEditActivity.class );

        try(ActivityScenario<CalendarFragment> CalendarScenario = ActivityScenario.launch(CalendarFragment.class)) {
            onView(withId(R.id.cellDayText)).perform(click());
            //assertNotEquals(CalendarScenario.getState(), Lifecycle.State.CREATED);
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