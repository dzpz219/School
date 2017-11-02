package ca.mohawk.zhang.excerciseeight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class SemesterTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_two);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_one);
        Intent intent = getIntent();
        String output = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(output);
    }
}
