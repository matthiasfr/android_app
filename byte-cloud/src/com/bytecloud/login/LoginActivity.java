package com.bytecloud.login;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity 
                  implements OnClickListener {

  Button _btnLogin;
  EditText _eTUser;
  EditText _eTPassword;

  String _userConst;
  String _passConst;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    
    _userConst = "root";
    _passConst = "1234";
    
    _btnLogin = (Button) findViewById(R.id.btnLogin);
    _eTUser = (EditText) findViewById(R.id.eTUser);
    _eTPassword = (EditText) findViewById(R.id.eTPassword);
    
    this._btnLogin.setOnClickListener(this);
  }

  @Override
  public void onClick(View v){
    if(_eTUser.getText().toString().equals(_userConst) && 
        _eTPassword.getText().toString().equals(_passConst))
    {
      
    }
    else
    {
      displayToast("User and Password do not match, please try reentering!");
    }
  }
  
  public void displayToast(CharSequence text){
    Context context = getApplicationContext();
    int duration = Toast.LENGTH_LONG;
    
    Toast toast = Toast.makeText(context, text, duration);
    toast.show();
  }

}
