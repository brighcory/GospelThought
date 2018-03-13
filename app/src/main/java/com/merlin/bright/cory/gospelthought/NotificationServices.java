package com.merlin.bright.cory.gospelthought;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by coryb on 1/21/2018.
 *
 */

public class NotificationServices extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        CharSequence name = getString(R.string.app_name);
        String description = MainActivity.getQuote();

        Notification.Builder mBuilder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle(name)
                        .setContentText(description);
        Notification notification = mBuilder.build();
        startForeground(11, notification);
        return Service.START_NOT_STICKY;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
