package com.example.simple_calc.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.simple_calc.MainActivity;
import com.robotium.solo.Solo;

public class Maintest extends ActivityInstrumentationTestCase2<MainActivity>{
	private Solo mySolo;
	
	public Maintest(){
		super(MainActivity.class);
	}
	
	protected void setUp() throws Exception{
		super.setUp();
		mySolo = new Solo(getInstrumentation(), getActivity());
	}
	
	protected void tearDown() throws Exception{
		super.tearDown();
	}
	
	public void testOutput(){
		mySolo.enterText(0, "123");
		mySolo.enterText(1, "321");
		mySolo.scrollListToLine(0, 1);
		mySolo.clickInList(1);
		mySolo.clickOnButton("Calc");
		mySolo.getText("444");
	}
}
