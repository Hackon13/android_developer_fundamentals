package com.example.activitylifecycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate Finished",Toast.LENGTH_SHORT).show();
        Log.i("Mainactivity","onCreate");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart Finished",Toast.LENGTH_SHORT).show();
        Log.i("Mainactivity","onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume Finished",Toast.LENGTH_SHORT).show();
        Log.i("Mainactivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause Finished",Toast.LENGTH_SHORT).show();
        Log.i("Mainactivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop Finished",Toast.LENGTH_SHORT).show();
        Log.i("Mainactivity","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart Finished",Toast.LENGTH_SHORT).show();
        Log.i("Mainactivity","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy Finished",Toast.LENGTH_SHORT).show();
        Log.i("Mainactivity","onDestroy");
    }
}