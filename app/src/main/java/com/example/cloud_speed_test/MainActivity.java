package com.example.cloud_speed_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    public void calcFibonacci(int n) {
        int firstTerm = 0, secondTerm = 1;
        long start1 = System.nanoTime();
        long start2 = System.currentTimeMillis();
        for (int i = 1; i <= n; ++i) {
            // compute the next term
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        long end1 = System.nanoTime();
        long end2 = System.currentTimeMillis();
        long time;
        textView = (TextView) findViewById(R.id.time);
        if (end1-start1 < 1000) {
            time = end1-start1;
            textView.setText("Time for execution: "+time+" ns");
            Log.d("Time: ns", String.valueOf(time));
        }
        else if (end1-start1 > 1000 && end1-start1 < 1000000) {
            time = (end1-start1)/1000;
            textView.setText("Time for execution: "+time+" us");
            Log.d("Time: us", String.valueOf(time));
        }
        else {
            time = end2 - start2;
            textView.setText("Time for execution: "+time+" ms");
            Log.d("Time: ms", String.valueOf(time));
        }
    }

    public void Run(View view) {
        editText = (EditText) findViewById(R.id.nValue);
        calcFibonacci(Integer.parseInt(editText.getText().toString()));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}