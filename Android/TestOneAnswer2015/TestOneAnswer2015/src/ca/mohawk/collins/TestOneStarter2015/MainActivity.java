package ca.mohawk.collins.TestOneStarter2015;

import ca.mohawk.collins.TestOneStarter2015.R;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements OnItemSelectedListener {
	public final static String EXTRA_MESSAGE = "msg";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Spinner spinner = (Spinner) findViewById(R.id.listofmonths);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.monthlist, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//spinner.setOnItemSelectedListener(this);
		spinner.setAdapter(adapter);
		
	}
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
	 Intent intent = new Intent(this, DisplayMessageActivity.class);
	 Spinner spinner = (Spinner) findViewById(R.id.listofmonths);
	 String message = (String) spinner.getItemAtPosition(pos);
	 intent.putExtra(EXTRA_MESSAGE, message);
	 startActivity(intent);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
	public void makeToast(View v) {
		EditText text = (EditText) findViewById(R.id.sometyping);
		String data = text.getText().toString();
		Toast.makeText(getBaseContext(), data, Toast.LENGTH_LONG).show();
	}

}
