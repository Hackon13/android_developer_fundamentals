package com.example.mynewalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    AlarmManager myAlarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        myAlarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void startSomething(View view) {
        Toast.makeText(this,"Alarm Started", Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent();
        i1.setAction("com.pop.myown.reciever.Message");
        i1.addCategory("android.intent.category.DEFAULT");
        PendingIntent pd = PendingIntent.getBroadcast(this,0,i1,0);

        myAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),1000 *15,pd);



    }

    public void stopSomethig(View view) {

        Intent i1 = new Intent();
        i1.setAction("com.pop.myown.reciever.Message");
        i1.addCategory("android.intent.category.DEFAULT");
        PendingIntent pd = PendingIntent.getBroadcast(this,0,i1,0);
        myAlarmManager.cancel(pd);
        Toast.makeText(this,"Alarm Stopped", Toast.LENGTH_SHORT).show();

    }
}