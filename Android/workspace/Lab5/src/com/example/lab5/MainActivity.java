package com.example.lab5;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	    Button button = (Button)findViewById(R.id.button1);

	    button.setOnClickListener(this);
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
	
	    public void onClick(View v) {
	    	
	    	EditText txt = (EditText)findViewById(R.id.editText1);
	    	String msg = txt.getText().toString();
	    	
	    	Intent sendIntent = new Intent();
	    	sendIntent.setAction(Intent.ACTION_SEND);
	    	sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
	    	sendIntent.setType("text/plain");
	    	PackageManager packageManager = getPackageManager();
	    	List activities = packageManager.queryIntentActivities(sendIntent, 0);
	    	boolean isIntentSafe = activities.size() > 0;	
	    	startActivity(sendIntent);
	    }
}
