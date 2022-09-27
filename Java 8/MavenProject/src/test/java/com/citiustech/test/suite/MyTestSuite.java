package com.citiustech.test.suite;

import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import com.citiustech.code.Calculator;
//import org.junit.platform.suite.api.Suite;

@Suite  // to run all the test cases in below packages

@SelectPackages("com.citiustech.test")
@IncludeTags("dev")  // only the test cases with dev tags will execute from someTest.java
//@SelectClasses({Lifecycle.class,Calculator.class}) //run all the test cases of below class
public class MyTestSuite {

}
