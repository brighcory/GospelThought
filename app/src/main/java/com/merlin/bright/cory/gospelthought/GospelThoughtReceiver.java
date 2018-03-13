package com.merlin.bright.cory.gospelthought;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by cory on 1/28/18.
 *
 */

public class GospelThoughtReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentGospelThoughtReceiver = new Intent(context, GospelThoughtServices.class);
        context.startService(intentGospelThoughtReceiver);
    }
}
