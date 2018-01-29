package com.merlin.bright.cory.gospelthought;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;

/**
 * Created by cory on 1/28/18.
 */

public class GospelThoughtServices extends IntentService{

    private static final int NOTIFICATION_ID = 3;

    public GospelThoughtServices() {
        super("GospelThoughtIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Gospel Thought");
        //Todo get inspiring quotes
        builder.setContentText("Here will be the thought");
        //Todo Make an icon for the App
//        builder.setLargeIcon(R.d)
        Intent notifyIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 2,
                new Intent[]{notifyIntent},
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notificationComp = builder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notificationComp);
    }
}
