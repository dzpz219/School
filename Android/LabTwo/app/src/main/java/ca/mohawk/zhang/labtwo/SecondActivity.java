package ca.mohawk.zhang.labtwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.textView2);
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        textView.setText(message);
    }
}
