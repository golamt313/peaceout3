package com.example.application;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {ExampleInstrumentedTest.class})
public class UnitTestSuite {}