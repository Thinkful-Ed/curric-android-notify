package com.interactivecoconut.notify;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
            Toast
         */
        Button mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Live long and prosper", Toast.LENGTH_SHORT);
                toast.show();
                toast.setGravity(Gravity.CENTER,0,0);
            }
        });
        /*
            Notify
         */
        Button notificationButton = (Button) findViewById(R.id.button2);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });
        /*
            Alarm
         */
        Button alarmButton = (Button) findViewById(R.id.button3);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm();
            }
        });


        Button cancelAlarmButton = (Button) findViewById(R.id.button4);
        cancelAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
    }
    protected void setAlarm() {
        Alarm alarm = new Alarm();
        alarm.setAlarm(this);
    }
    protected void cancelAlarm() {
        Alarm alarm = new Alarm();
        alarm.cancelAlarm(this);
    }
    //REFACTORED - moved to Alarm class


    protected void displayNotification() {
        Notifier notifier = new Notifier();
        notifier.createNotification(this);
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
