package com.hegdeganesh.studyprojects.tipcalculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;//for saving state information

public class TipCalculatorActivity extends AppCompatActivity {//calculates a bill total based on a tip percentage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }
}
/*
* This application is developed to clculate and display the tip and total for a restaurant bill amount.
* The current tip percentage is 10% of the bill amount. As soon as the keypad is touched to enter the
* bill amount, the app calculates and displays the tip and total bill amounts for the current tip
* percentage.
* You can specify a tip percentage from 0% to 30% by moving the seekbar thumb - this updates the
* displayed tip percentage and recalculates the tip and total. All numerica values are displayed according to
* local-specific formatting.
*
* You will use:
* 1) Various Android classes and objects
* 2) Call methods on classes and objects
* 3) define and call your own methods
* 4) use inheritance to create a class that defines the TipCalculator's functionality
* 5) Use event handling,anonymous inner classes and interfaces to process the user's GUI
    interactions.
* */

/*
* Class Bundle stores key-value pairs of information - typically representing an app's state or data that needs to be passed between activities.
* When another app is about to appear on the screen - example, when the user receives a phone call or launches another app - Android
* gives the currently executing app the opportunity to save its state in a Bundle. The Android runtime might subsequently kill the app - example,
* to reclaim the memory.When the app returns to the screen, the Android runtime passes the Bundle of the previously saved state to Activity
* method onCreate. Then the app can use the saved state to return the app to the state it was in when another app became active.
*
* Class AppCompatActivity provides the basic lifecycle methods of an app. AppCompatActivity is an indirect class of Activity that supports
* using newer android features apps running on current and older Android platforms.
* */

