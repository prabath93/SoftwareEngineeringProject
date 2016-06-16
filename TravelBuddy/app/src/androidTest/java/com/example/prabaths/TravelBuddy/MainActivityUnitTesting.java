package com.example.prabaths.TravelBuddy;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.prabaths.Data.DAO.InstantDataDAO;
import com.example.prabaths.Data.DAO.VehicleDAO;
import com.example.prabaths.Fragments.Home_Fragment;
import com.example.prabaths.VO.InstantData;
import com.example.prabaths.VO.Vehicle;
import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

import java.text.ParseException;

/**
 * Created by prabath s on 6/15/2016.
 */
public class MainActivityUnitTesting extends ActivityInstrumentationTestCase2 {
    private Solo solo;
    public MainActivityUnitTesting() {

        super(Login_Activity.class);


    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo=new Solo(getInstrumentation(),getActivity());



    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }


    public void testName() throws Exception {
        //Wait for activity: 'com.example.prabaths.TravelBuddy.Login_Activity'
        solo.waitForActivity("Login_Activity", 2000);

        //add new user to the system
        addUser();

        //Click on userNameTxt
        solo.clickOnView(solo.getView("userNameTxt"));
        //Enter the text: 'prabath'
        solo.clearEditText((android.widget.EditText) solo.getView("userNameTxt"));
        solo.enterText((android.widget.EditText) solo.getView("userNameTxt"), "testing");
        //Click on passwordTxt
        solo.clickOnView(solo.getView("passwordTxt"));
        //Enter the text: '1'
        solo.clearEditText((android.widget.EditText) solo.getView("passwordTxt"));
        solo.enterText((android.widget.EditText) solo.getView("passwordTxt"), "1");
        //Click on Login
        solo.clickOnView(solo.getView("loginBtn"));
        //Wait for activity: 'com.example.prabaths.TravelBuddy.MainActivity'
        assertTrue("MainActivity is not found!", solo.waitForActivity("MainActivity"));
        //Click on Log
        solo.clickOnText(java.util.regex.Pattern.quote("Log"));
        //Click on Vehicle Details
        solo.clickOnText(java.util.regex.Pattern.quote("Vehicle Details"));
        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Scroll to ----- Expenses ----
        android.widget.ListView listView0 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
        solo.scrollListToLine(listView0, 0);
        //Click on ----- Expenses ----
        solo.clickInList(2, 0);
        //Assert that: 'View' is shown
        assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 49)));
        //Assert that: 'View' is shown
        assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 49)));
        //Assert that: 'View' is shown
        assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 49)));
        //Set default small timeout to 27504 milliseconds
        Timeout.setSmallTimeout(27504);
        //Click on Other Expense
        solo.clickOnText(java.util.regex.Pattern.quote("Other Expense"));
        //Click on Fuel Expense
        solo.clickOnText(java.util.regex.Pattern.quote("Fuel Expense"));
        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Scroll to Add Fuel Expense
        android.widget.ListView listView1 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
        solo.scrollListToLine(listView1, 1);
        //Click on Add Fuel Expense
        solo.clickOnText(java.util.regex.Pattern.quote("Add Fuel Expense"));

        //Click on Turn on Internet
        //solo.clickOnView(solo.getView("turnOnInternetBtn"));
        //Wait for dialog
        ///solo.waitForDialogToOpen(5000);
        //Click on Cancel
        //solo.clickOnView(solo.getView(android.R.id.button2));
        //Wait for dialog to close
        //solo.waitForDialogToClose(5000);
        //Click on Turn on Internet
        //solo.clickOnView(solo.getView("turnOnInternetBtn"));
        //Wait for dialog
        //solo.waitForDialogToOpen(5000);
        //Click on Settings
        //solo.clickOnView(solo.getView(android.R.id.button1));
        //Click on Empty Text View

        //Submit a fuel expense
        //submitFuelExpense();

        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Scroll to Other Expense
        android.widget.ListView listView2 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
        solo.scrollListToLine(listView2, 2);
        //Click on Other Expense
        solo.clickOnText(java.util.regex.Pattern.quote("Other Expense"));

        //Submit other expense record
        submitOtherExpense();

        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Scroll to View Vehicle Detail
        android.widget.ListView listView3 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
        solo.scrollListToLine(listView3, 4);
        //Click on View Vehicle Detail
        solo.clickOnText(java.util.regex.Pattern.quote("View Vehicle Detail"));
        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Click on Edit Vehicle Details
        solo.clickOnText(java.util.regex.Pattern.quote("Edit Vehicle Details"));

        //submit edit vehicle
        submitVehicleDetailsEdit();
        //Set default small timeout to 42336 milliseconds
        Timeout.setSmallTimeout(4233);

        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Scroll to View Profile
        android.widget.ListView listView4 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
        solo.scrollListToLine(listView4, 6);
        //Click on View Profile
        solo.clickOnText(java.util.regex.Pattern.quote("View Profile"));
        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Click on Edit Profile
        solo.clickOnText(java.util.regex.Pattern.quote("Edit Profile"));

        submitEditProfile();

        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Scroll to ----- Statistics ----
        android.widget.ListView listView5 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
        solo.scrollListToLine(listView5, 8);
        //Click on ----- Statistics ----
        solo.clickOnText(java.util.regex.Pattern.quote("----- Statistics ----"));
        //Assert that: 'View' is shown
        assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 34)));
        //Assert that: 'View' is shown
        assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 34)));
        //Click on Patterns
        solo.clickOnText(java.util.regex.Pattern.quote("Patterns"));
        //Click on Empty Text View
        solo.clickOnView(solo.getView("fuelGraphBtn"));
        //Wait for activity: 'com.example.prabaths.inner.activity.Fuel_Expense_Graph_Activity'
        assertTrue("Fuel_Expense_Graph_Activity is not found!", solo.waitForActivity("Fuel_Expense_Graph_Activity"));
        //Click on Empty Text View
        solo.clickOnView(solo.getView("backBtn3"));
        solo.clickOnView(solo.getView("otherGraphBtn"));
        //Wait for activity: 'com.example.prabaths.inner.activity.Other_Expense_Graph_Activity'
        assertTrue("Other_Expense_Graph_Activity is not found!", solo.waitForActivity("Other_Expense_Graph_Activity"));
        //Click on Empty Text View
        solo.clickOnView(solo.getView("backBtn4"));
        //Click on Empty Text View
        solo.clickOnView(solo.getView("economyBtn"));
        //Wait for activity: 'com.example.prabaths.inner.activity.Economy_Graph_Activity'
        assertTrue("Economy_Graph_Activity is not found!", solo.waitForActivity("Economy_Graph_Activity"));
        //Click on Empty Text View
        solo.clickOnView(solo.getView("backBtn5"));
        //Click on Details
        solo.clickOnText(java.util.regex.Pattern.quote("Details"));
        //Assert that: 'View' is shown
        assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 34)));
        //Assert that: 'View' is shown
        assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 34)));
        //Assert that: 'View' is shown
        assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 34)));
        //Assert that: 'View' is shown
        assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 34)));
        //Assert that: 'View' is shown
        assertTrue("'View' is not shown!", solo.waitForView(solo.getView(android.view.View.class, 34)));

        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Scroll to Comparison
        android.widget.ListView listView6 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
        solo.scrollListToLine(listView6, 8);
        //Click on Comparison
        solo.clickOnText(java.util.regex.Pattern.quote("Comparison"));
        //Scroll View to the right side
        solo.scrollViewToSide(solo.getView(android.widget.HorizontalScrollView.class, 1), Solo.RIGHT, 0.176F);
        //Click on ImageView
        solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Scroll to Patterns
        android.widget.ListView listView7 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
        solo.scrollListToLine(listView7, 8);
        //Click on Patterns
        solo.clickOnText(java.util.regex.Pattern.quote("Patterns"));



    }

    public void submitFuelExpense(){
        //Click on Empty Text View
        solo.clickOnView(solo.getView("odometerReadingTxt"));
        //Enter the text: '4500'
        solo.clearEditText((android.widget.EditText) solo.getView("odometerReadingTxt"));
        solo.enterText((android.widget.EditText) solo.getView("odometerReadingTxt"), "4500");
        //Click on Empty Text View
        solo.clickOnView(solo.getView("volumeTxt"));
        //Enter the text: '4'
        solo.clearEditText((android.widget.EditText) solo.getView("volumeTxt"));
        solo.enterText((android.widget.EditText) solo.getView("volumeTxt"), "4");
        //Click on Empty Text View
        solo.clickOnView(solo.getView("unitPriceTxt"));
        //Enter the text: '4'
        solo.clearEditText((android.widget.EditText) solo.getView("unitPriceTxt"));
        solo.enterText((android.widget.EditText) solo.getView("unitPriceTxt"), "70");
        //Enter the text:
        solo.clearEditText((android.widget.EditText) solo.getView("totalCostTxt"));
        solo.enterText((android.widget.EditText) solo.getView("totalCostTxt"), "280");
        //Click on Empty Text View
        solo.clickOnView(solo.getView("locationTxt"));
        //Click on Add Location
        solo.clickOnView(solo.getView("autoLocationBtn"));
        //Click on Empty Text View
        solo.clickOnView(solo.getView("locationTxt"));
        //Enter the text: 'Agalawatta'
        solo.clearEditText((android.widget.EditText) solo.getView("locationTxt"));
        solo.enterText((android.widget.EditText) solo.getView("locationTxt"), "Agalawatta");
        //Click on Submit
        solo.clickOnView(solo.getView("fuelRefillSubmitBtn"));
    }

    private void submitOtherExpense(){
        //Click on Service
        solo.clickOnView(solo.getView("serviceRadioBtn"));
        //Click on Empty Text View
        solo.clickOnView(solo.getView("costTxt"));
        //Enter the text: '2500'
        solo.clearEditText((android.widget.EditText) solo.getView("costTxt"));
        solo.enterText((android.widget.EditText) solo.getView("costTxt"), "2500");
        //Click on Submit
        solo.clickOnView(solo.getView("otherExpenseSubmitBtn"));
    }

    private void submitVehicleDetailsEdit(){
        //Click on 2016
        solo.clickOnView(solo.getView("yearEditTxt1"));
        //Enter the text: '2011'
        solo.clearEditText((android.widget.EditText) solo.getView("yearEditTxt1"));
        solo.enterText((android.widget.EditText) solo.getView("yearEditTxt1"), "2011");
        //Click on Save
        solo.clickOnView(solo.getView("submitEditBtn"));
    }

    private void submitEditProfile(){
        //Click on nameTxt
        solo.clickOnView(solo.getView("nameEditTxt1"));
        //Enter the text: 'sandaruwan'
        solo.clearEditText((android.widget.EditText) solo.getView("nameEditTxt1"));
        solo.enterText((android.widget.EditText) solo.getView("nameEditTxt1"), "Sandaruwan");
        //Click on nicTxt
        solo.clickOnView(solo.getView("nicEditTxt1"));
        //Enter the text: '933662307v'
        solo.clearEditText((android.widget.EditText) solo.getView("nicEditTxt1"));
        solo.enterText((android.widget.EditText) solo.getView("nicEditTxt1"), "933662307v");
        //Click on telNoTxt
        solo.clickOnView(solo.getView("telNoEditTxt1"));
        //Enter the text: '0719561618'
        solo.clearEditText((android.widget.EditText) solo.getView("telNoEditTxt1"));
        solo.enterText((android.widget.EditText) solo.getView("telNoEditTxt1"), "0719561618");
        //Click on Save
        solo.clickOnView(solo.getView("submitBtn3"));
    }

    private void addUser(){
        //Click on Sign up
        solo.clickOnView(solo.getView("signUpBtn"));
        //Wait for dialog
        solo.waitForDialogToOpen(5000);
        //Click on Empty Text View
        solo.clickOnView(solo.getView("nameEditTxt"));
        //Enter the text: 'prabath '
        solo.clearEditText((android.widget.EditText) solo.getView("nameEditTxt"));
        solo.enterText((android.widget.EditText) solo.getView("nameEditTxt"), "prabath ");
        //Click on Empty Text View
        solo.clickOnView(solo.getView("nicEditTxt"));
        //Enter the text: '933662307v'
        solo.clearEditText((android.widget.EditText) solo.getView("nicEditTxt"));
        solo.enterText((android.widget.EditText) solo.getView("nicEditTxt"), "933662307v");
        //Click on Empty Text View
        solo.clickOnView(solo.getView("emailEditTxt"));
        //Enter the text: 'prabath.sandaruwan@gmail.com'
        solo.clearEditText((android.widget.EditText) solo.getView("emailEditTxt"));
        solo.enterText((android.widget.EditText) solo.getView("emailEditTxt"), "prabath.sandaruwan@gmail.com");
        //Click on Empty Text View
        solo.clickOnView(solo.getView("userNameEditTxt"));
        //Enter the text: 'pra'
        solo.clearEditText((android.widget.EditText) solo.getView("userNameEditTxt"));
        solo.enterText((android.widget.EditText) solo.getView("userNameEditTxt"), "pra1");
        //Enter the text: '1'
        solo.clearEditText((android.widget.EditText) solo.getView("passwordEditTxt"));
        solo.enterText((android.widget.EditText) solo.getView("passwordEditTxt"), "1");
        //Enter the text: '1'
        solo.clearEditText((android.widget.EditText) solo.getView("confirmPasswordEditTxt"));
        solo.enterText((android.widget.EditText) solo.getView("confirmPasswordEditTxt"), "1");
        //Click on Submit
        solo.clickOnView(solo.getView("submitAccountButton"));
        //Click on Cancel
        solo.clickOnView(solo.getView("cancelBtn"));
    }
}
