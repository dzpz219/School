package com.example.lab3;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity {
	
	public TextView textview;
	public int orientation;
	public String msg;
	public String buildVersion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
		textview = (TextView) findViewById(R.id.textView1);
		msg = getString(R.string.deviceMsg);
		buildVersion = getString(R.string.deviceBuildVersion) + Build.VERSION.SDK_INT;
		orientation = getResources().getConfiguration().orientation;
		if (orientation == 1){
			msg += " " + getString(R.string.devicePortrait) + " " + buildVersion;
		}
		else {
			msg += " " + getString(R.string.deviceLandscape) + " " + buildVersion;
		}
		textview.setText(msg);
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
	
	public void firstActivity(View view){
		this.finish();
	}
}
