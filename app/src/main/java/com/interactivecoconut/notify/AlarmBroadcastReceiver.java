package com.interactivecoconut.notify;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class AlarmBroadcastReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent notifyService = new Intent(context, NotifyService.class);
        startWakefulService(context, notifyService);
    }
}
