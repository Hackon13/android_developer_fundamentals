package com.example.mynotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void doSomething(View view) {
        NotificationManagerCompat myManager = NotificationManagerCompat.from(this);

        NotificationCompat.Builder myNoti = new NotificationCompat.Builder(this)
                .setContentTitle("1 New Message")
                .setContentText("Hi how are you?")
                .setSmallIcon(android.R.drawable.ic_btn_speak_now)
                .setAutoCancel(true);

        Intent i1 = new Intent(this, MainActivity.class);
        PendingIntent pd = PendingIntent.getActivity(this, 1, i1, PendingIntent.FLAG_UPDATE_CURRENT);
        myNoti.setContentIntent(pd);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        myManager.notify(1, myNoti.build());
        finish();
    }
}
