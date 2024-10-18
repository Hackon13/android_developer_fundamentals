package com.example.newasyncinternet;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
DownloadImageTask downloadImage;
    static TextView myText;
    static ImageView myImage;

    ConnectivityManager myConnManager;
    NetworkInfo myInfo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        myText = (TextView)findViewById(R.id.myResult);
        myImage = (ImageView)findViewById(R.id.myimage);

        myConnManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        myInfo = myConnManager.getActiveNetworkInfo();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void doSomething(View view) {
        c1 = new ConnectInternetTask(this);
        c1.execute("http://www.google.com");



    }

    public void downloadImage(View view) {
        if (myInfo != null && myInfo.isConnected()){
            downloadImage = new DownloadImageTask();
            downloadImage.execute("https://developer.android.com/static/assets/images/resource-card-default-android.jpg");
        }
        else {
            Toast.makeText(this, "Internet Not Connected", Toast.LENGTH_SHORT).show();
        }
    }
}