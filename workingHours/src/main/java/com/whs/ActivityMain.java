package com.whs;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.melnykov.fab.FloatingActionButton;
import java.util.ArrayList;
import java.util.HashMap;

public class ActivityMain extends ActionBarActivity implements OnMapReadyCallback {
    MapFragment mapFragment;
    GoogleMap myMap;
    Location location;
    LocationManager locationManager;
    ListView listView;
    ArrayList<HashMap<String,String>> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        arrayList = new ArrayList<HashMap<String,String>>();
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                arrayList,
                R.layout.list_item,
                new String[] {Preferences.getStoreName(), Preferences.getStoreTime()},
                new int[] {R.id.item_title,R.id.item_description}

        );
        populateList();
        listView.setAdapter(adapter);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToListView(listView);
        fab.show();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(getApplicationContext(), ActivityAdd.class);
                startActivity(intentAdd);
                finish();
            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), getString(position), Toast.LENGTH_SHORT).show();
            }
        });



        if (1 == 1) {//check internet connection+Wifi+GPS
            mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
            myMap = mapFragment.getMap();

        } else {
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                //http://novoda.com/blog/styling-the-actionbar-searchview/
                return true;
            case R.id.action_location:
                LatLng latLng = new LatLng(Preferences.getLatitude(this), Preferences.getLongitude(this));
                myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
                myMap.addMarker(new MarkerOptions().position(latLng).title(getString(R.string.marker_curr_location_title)));
                return true;
            case R.id.action_settings:
                Intent intentSet = new Intent(this, ActivitySet.class);
                startActivity(intentSet);
                return true;
            case R.id.action_about:
                Intent intentAbout = new Intent(this, ActivityAbout.class);
                startActivity(intentAbout);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng currLoc = new LatLng(Preferences.getLatitude(this), Preferences.getLongitude(this));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(currLoc, 16));
        //http://startandroid.ru/ru/uroki/vse-uroki-spiskom/291-urok-138-opredelenie-mestopolozhenija-gps-koordinaty.html
        /*map.addMarker(new MarkerOptions().position(currLoc)
                .title("I am there")
                .snippet("test test test test test test test test!")
        );*/
    }



    /*public void showLocation(Location location) {
        if (location == null)
            return;
        if (location.getProvider().equals(LocationManager.GPS_PROVIDER)) {
            Preferences.setLatitude(this, (float) location.getLatitude());
            Preferences.setLongitude(this, (float) location.getLongitude());
            textCurrentLocation.setText(formatLocation(location));
        } else if (location.getProvider().equals(LocationManager.NETWORK_PROVIDER)) {
            Preferences.setLatitude(this, (float) location.getLatitude());
            Preferences.setLongitude(this,(float) location.getLongitude());
            textCurrentLocation.setText(formatLocation(location));
        }
    }

    public String formatLocation(Location location) {
        if (location == null)
            return "...";
        return String.format(
                "Latitude = %1$.8f, Longitude = %2$.8f",location.getLatitude(), location.getLongitude());
    }*/

    public void populateList() {
        HashMap<String,String> temp;
        for (int i = 0; i<25;i++){
            temp = new HashMap<String, String>();
            temp.put(Preferences.getStoreName(), "Store " + i);
            temp.put(Preferences.getStoreTime(), "200.00$ + time " + i*100);
            arrayList.add(temp);
        }
    }
}