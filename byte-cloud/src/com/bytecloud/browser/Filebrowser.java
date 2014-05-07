package com.bytecloud.browser;

import java.util.ArrayList;
import java.util.List;

import com.bytecloud.login.R;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;

public class Filebrowser extends Activity implements OnClickListener{
    
    
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_filebrowser);
    
    final ArrayList<String> list = new ArrayList<String>();
    
    final ArrayAdapter adapter = new ArrayAdapter(this, 
        android.R.layout.simple_list_item_1, list);
  }
  
    @Override
    public void onClick(View v) {
      // TODO Auto-generated method stub
      
    }
}
