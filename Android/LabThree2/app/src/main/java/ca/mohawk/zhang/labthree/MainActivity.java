package ca.mohawk.zhang.labthree;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Integer count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button plus = (Button) findViewById(R.id.plus);
        final Button minus = (Button) findViewById(R.id.minus);
        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(count.toString());

        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count++;
                textView.setText(count.toString());
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count--;
                textView.setText(count.toString());
            }
        });
    }
}
