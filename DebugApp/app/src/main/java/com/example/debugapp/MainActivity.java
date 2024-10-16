package com.example.debugapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    TextView tv1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.edit1);
        e2 = (EditText) findViewById(R.id.edit2);
        tv1= (TextView)findViewById(R.id.myresult);


    }

    public void doAdd(View view) {
        int a1= Integer.parseInt(e1.getText().toString());
        int a2= Integer.parseInt(e2.getText().toString());
        int result = a1+a2;
        tv1.setText(""+result);

    }
}