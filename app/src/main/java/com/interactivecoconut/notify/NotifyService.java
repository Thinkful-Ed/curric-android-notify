package com.interactivecoconut.notify;

import android.app.IntentService;
import android.content.Intent;


public class NotifyService extends IntentService {

    public NotifyService() {
        super("NotifyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Notification notification = new Notification();
        notification.createNotification(this);
        AlarmBroadcastReceiver.completeWakefulIntent(intent);
    }

}
