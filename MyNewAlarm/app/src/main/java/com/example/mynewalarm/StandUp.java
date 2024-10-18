package com.example.mynewalarm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class StandUp extends BroadcastReceiver {

    private static final String CHANNEL_ID = "stand_up_channel";

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Inside Receiver", Toast.LENGTH_SHORT).show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Stand Up Reminder";
            String description = "Channel for stand-up notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationManagerCompat myManager = NotificationManagerCompat.from(context);
        NotificationCompat.Builder myNoti = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("Stand UP Notification")
                .setContentText("You need to stand up")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        Intent i1 = new Intent(context, StandUPActivity.class);
        PendingIntent pd = PendingIntent.getActivity(context, 0, i1, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        myNoti.setContentIntent(pd);

        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        myManager.notify(1, myNoti.build());
    }
}
