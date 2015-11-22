package com.whs;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySet extends ActionBarActivity implements OnClickListener {

    Button buttonGps;
    Button buttonWifi;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        buttonGps = (Button) findViewById(R.id.buttonGps);
        buttonWifi = (Button) findViewById(R.id.buttonWifi);

        buttonGps.setOnClickListener(this);
        buttonWifi.setOnClickListener(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        checkServicesEnabled();
    }

    @Override
    protected void onResume() {
        super.onResume();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000 * Preferences.getTimeRefreshServices()
                , Preferences.getDistanceRefreshServices(), locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000 * Preferences.getTimeRefreshServices()
                , Preferences.getDistanceRefreshServices(), locationListener);
        checkServicesEnabled();
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(locationListener);
    }

    private LocationListener locationListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {
            checkServicesEnabled();
        }

        @Override
        public void onProviderDisabled(String provider) {
            checkServicesEnabled();
        }

        @Override
        public void onProviderEnabled(String provider) {
            checkServicesEnabled();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            checkServicesEnabled();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonGps:
                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                break;
            case R.id.buttonWifi:
                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                break;
            default:
                break;
        }
    }

    public void checkServicesEnabled() {
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) == true) {
            buttonGps.setBackgroundResource(R.color.white);
            buttonGps.setText(getString(R.string.activity_set_button_gps_d));
        }else {
            buttonGps.setBackgroundResource(R.color.blue);
            buttonGps.setText(getString(R.string.activity_set_button_gps_e));
        };

        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) == true) {
            buttonWifi.setBackgroundResource(R.color.white);
            buttonWifi.setText(getString(R.string.activity_set_button_wifi_d));
        }else {
            buttonWifi.setBackgroundResource(R.color.blue);
            buttonWifi.setText(getString(R.string.activity_set_button_wifi_e));
        };
    }
}