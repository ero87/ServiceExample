package com.example.hp.serviceexamples;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;


public class MyLocationService extends Service {

    private LocationManager locationManager;
    private String provider;
    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Toast.makeText(getApplicationContext(), "Changed......", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {
            Toast.makeText(getApplicationContext(), "Enable......", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderDisabled(String s) {
            Toast.makeText(getApplicationContext(), "Disable......", Toast.LENGTH_SHORT).show();
        }
    };

    public MyLocationService() {
    }

    @SuppressLint("MissingPermission")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        locationManager.requestLocationUpdates(provider, 0, 0, locationListener);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);

        provider = locationManager.getBestProvider(criteria, true);
    }
}
