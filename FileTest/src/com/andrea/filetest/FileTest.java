package com.andrea.filetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class FileTest extends ActionBarActivity implements OnClickListener {

  private EditText eTpath;
  private Button bOpen;
  private Button bCreate;
  
  FileOutputStream fos;
  String FILENAME = "hello_file.txt";
  String FILE_CONTENT = "hello world!";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_file_test);

    eTpath = (EditText) findViewById(R.id.eTpath);
    bOpen = (Button) findViewById(R.id.bOpen);
    bCreate = (Button) findViewById(R.id.bCreate);
    
    this.bOpen.setOnClickListener(this);
    this.bCreate.setOnClickListener(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.file_test, menu);
    return true;
  }

  public void onClick(View v) {
    // TODO Auto-generated method stub
    switch (v.getId()) {
    case R.id.bOpen:
      readFile(FILENAME);
      break;

    case R.id.bCreate:
      createFile();
      break;
      
    default:
      break;
    }
  }

  @SuppressWarnings("deprecation")
  private void createFile() {
    FileOutputStream fos;
    
    try {
      fos = openFileOutput(FILENAME, MODE_WORLD_READABLE);
      fos.write(FILE_CONTENT.getBytes());
      fos.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  private void readFileToText(String filepath){
    FileInputStream fis;
    StringBuffer fileContent = new StringBuffer("");
    byte[] buffer = new byte [1024];
    
    try {
      fis = openFileInput(filepath);
      while(fis.read(buffer) != -1){
        fileContent.append(new String(buffer));
      }
      
      fis.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      displayToast("FNF Exception");
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      
      displayToast("IO Exception");
      e.printStackTrace();
    }
    
    eTpath.setText(fileContent.toString());

  }
  
  
  private void readFile(String filepath){

    Context context = getApplicationContext();
    Intent intent = new Intent();
    intent.setAction(android.content.Intent.ACTION_VIEW);
    File file = new File(context.getFilesDir(), FILENAME);
    
    if(!file.exists())
    {
      displayToast("File doesn't exist.");
      return;
    }
  
    MimeTypeMap mime = MimeTypeMap.getSingleton();
    String ext=file.getName().substring(file.getName().lastIndexOf(".") + 1).toLowerCase();
    String type = mime.getMimeTypeFromExtension(ext);
    
    if(type == null)
    {
      displayToast("Invalid Extension of file.");
      return;
    }
 
    intent.setDataAndType(Uri.fromFile(file),type);
  
    startActivity(intent); 
  } 
  
  public void displayToast(CharSequence text){
    Context context = getApplicationContext();
    int duration = Toast.LENGTH_LONG;
    
    Toast toast = Toast.makeText(context, text, duration);
    toast.show();
  }
}