package com.interactivecoconut.notify;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    private int notificationID = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
            Notify
         */
        Button notificationButton = (Button) findViewById(R.id.button);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });
        /*
            Alarm
         */
        Button alarmButton = (Button) findViewById(R.id.button2);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm();
            }
        });


        Button cancelAlarmButton = (Button) findViewById(R.id.button3);
        cancelAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
    }

    protected void setAlarm() {
        //get reference to AlarmManager
        AlarmManager alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);

        //Elapsed real time non-repeating
        /*
        alarmMgr.set(AlarmManager.ELAPSED_REALTIME,
                  SystemClock.elapsedRealtime() + 10 * 1000,
                  getMainActivityPendingIntent());
        */

        //Elapse real time repeating
        /*
        alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 10 * 1000,
                10 * 1000, getMainActivityPendingIntent());
        */

        //RTC alarm repeating
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 16);
        calendar.set(Calendar.MINUTE, 18);
        long milliseconds = calendar.getTimeInMillis();

        alarmMgr.setInexactRepeating(AlarmManager.RTC, milliseconds,
                AlarmManager.INTERVAL_DAY, getMainActivityPendingIntent());

    }
    protected void cancelAlarm() {
        AlarmManager alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmMgr.cancel(getMainActivityPendingIntent());
    }
    protected PendingIntent getMainActivityPendingIntent() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return(pendingIntent);
    }
    protected void displayNotification() {
        //Build your notification
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(
                this);
        nBuilder.setContentTitle("Notification");
        nBuilder.setContentText("This is a Notification");
        nBuilder.setSmallIcon(R.drawable.ic_launcher);
        nBuilder.setAutoCancel(true);

        //Add a notification action
        nBuilder.setContentIntent(getMainActivityPendingIntent());

        //post notification
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationID, nBuilder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
