package com.example.lab6a;

import android.support.v7.app.ActionBarActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {
	
	private View koala;
	private View penguin;
	private int mShortAnimationDuration;
	private boolean flag = true;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		koala = findViewById(R.id.koala);
		penguin = findViewById(R.id.penguin);
		koala.setVisibility(View.GONE);
		
		mShortAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);
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
	
	public void flip(View view){
				
		if (flag){
			penguin.setVisibility(View.GONE);
			koala.setAlpha(0f);
			koala.setVisibility(View.VISIBLE);
			koala.animate()
            .alpha(1f)
            .setDuration(mShortAnimationDuration);
		}
		
		else
		{
			koala.setVisibility(View.GONE);
			
			penguin.setAlpha(0f);
			penguin.setVisibility(View.VISIBLE);
			
			penguin.animate()
            .alpha(1f)
            .setDuration(mShortAnimationDuration);
		}
		flag = !flag;	 
    }
	
	public void flipActivity(View view){
		startActivity(new Intent (this, CardFlipActivity.class));
	}
}
