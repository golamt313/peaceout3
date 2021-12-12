package com.example.application.fragments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;


public class CalendarAdapterTest {
    @Mock
    public ArrayList<LocalDate> days;
    public CalendarAdapter.OnItemListener onItemListener;
    public CalendarAdapter testobject;

    @Before
    public void setUp() throws Exception {
        testobject = new CalendarAdapter(days, onItemListener);
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void test()
    {
        Assert.assertNotNull(testobject);
        Assert.assertEquals(days, testobject.getItemCount());
    }
}