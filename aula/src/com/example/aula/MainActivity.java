package com.example.aula;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button bt;
	EditText et;
	TextView tv;

	static String strEt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		bt = (Button) findViewById(R.id.button1);
		et = (EditText) findViewById(R.id.editText1);
		tv = (TextView) findViewById(R.id.textView1);

		if (savedInstanceState != null) {
			restauraStrings(savedInstanceState);
		} 

		bt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Editable texto = et.getText();
				strEt = texto.toString();
				
				tv.setText(strEt);

				Toast toast = Toast.makeText(v.getContext(), texto,
						Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		restauraStrings(savedInstanceState);
	}

	private void restauraStrings(Bundle savedInstanceState) {
		String sEt;
		sEt = savedInstanceState.getString(strEt);

		if (sEt != null) {
			et.setText(sEt);
			tv.setText(sEt);
		}
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		String strSalva = et.getText().toString(); 
		savedInstanceState.putString(strEt, strSalva);
	}
}
