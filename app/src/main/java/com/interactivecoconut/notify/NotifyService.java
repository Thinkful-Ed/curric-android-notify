package com.interactivecoconut.notify;

import android.app.IntentService;
import android.content.Intent;


public class NotifyService extends IntentService {

    public NotifyService() {
        super("NotifyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Notifier notifier = new Notifier();
        notifier.createNotification(this);
        AlarmBroadcastReceiver.completeWakefulIntent(intent);
    }

}
