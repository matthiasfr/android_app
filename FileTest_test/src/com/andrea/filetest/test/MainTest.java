package com.andrea.filetest.test;

import android.test.ActivityInstrumentationTestCase2;

import com.andrea.filetest.FileTest;
import com.robotium.solo.Solo;

public class MainTest extends ActivityInstrumentationTestCase2<FileTest>{

  private Solo solo;
  
  public MainTest(){
    super(FileTest.class);
  }
  
  protected void setUp() throws Exception{
    super.setUp();
    solo = new Solo(getInstrumentation(), getActivity());
  }
  
  public void tearDown() throws Exception{
    super.tearDown();
  }
  
  public void testButtons(){
    solo.clickOnButton("Create");
    solo.clickOnButton("Open");
  }
  
}
