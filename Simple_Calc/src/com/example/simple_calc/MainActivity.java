package com.example.simple_calc;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener{

	private Button buttonCalc;
	private EditText inputText1;
	private EditText inputText2;
	private TextView resultText;
	private ListView listOps;
	
	String selected = "add";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.listOps = (ListView) this.findViewById(R.id.listOperations);
		String[] values = new String[] {"add", "sub", "mul", "div"};
		
		final ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < values.length; ++i)
		{
			list.add(values[i]);
		}
		
		final ArrayAdapter adapter = new ArrayAdapter(this, 
				android.R.layout.simple_list_item_1, list);
		listOps.setAdapter(adapter);
		
		listOps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, final View view, 
					int position, long id){
				selected = (String) parent.getItemAtPosition(position);
			}
		});
		
		this.buttonCalc = (Button) this.findViewById(R.id.buttonCalc);
		this.inputText1 = (EditText) this.findViewById(R.id.editText1);
		this.inputText2 = (EditText) this.findViewById(R.id.editText2);
		this.resultText = (TextView) this.findViewById(R.id.textResult);
		
		this.buttonCalc.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View v){
		int firstNumber = Integer.valueOf(this.inputText1.getText().toString());
		int secondNumber = Integer.valueOf(this.inputText2.getText().toString());
		int result = 0;
		
		if(selected.equals("add"))
		{
			result = firstNumber + secondNumber;
		}
		else if(selected.equals("sub"))
		{
			result = firstNumber - secondNumber;
		}
		else if(selected.equals("mul"))
		{
			result = firstNumber * secondNumber;
		}
		else if(selected.equals("div"))
		{
			result = firstNumber / secondNumber;
		}

		this.resultText.setText(String.valueOf(result));
	}
}
