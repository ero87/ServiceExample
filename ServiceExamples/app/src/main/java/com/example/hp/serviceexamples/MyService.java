package com.example.hp.serviceexamples;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.TextView;
import android.widget.Toast;

public class MyService extends Service {


    private MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//
//        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
//
//        for (int i = 0; i < 10000; ++i) {
//            if (i == 8000) {
//                try {
//                    Thread.sleep(80);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Toast.makeText(this, "Service Stoped", Toast.LENGTH_SHORT).show();
//                stopSelf();
//
//            }
//        }
//
//        return START_NOT_STICKY;
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
         mediaPlayer =  MediaPlayer.create(this,R.raw.nirv);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
