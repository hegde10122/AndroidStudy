package com.hegdeganesh.studyprojects.tipcalculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TipCalculatorActivity extends AppCompatActivity {

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

