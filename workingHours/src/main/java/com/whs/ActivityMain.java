package com.whs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.melnykov.fab.FloatingActionButton;
import com.whs.model.Store;
import com.whs.model.StoreRepository;
import java.util.ArrayList;
import java.util.HashMap;
import io.realm.RealmResults;

public class ActivityMain extends AppCompatActivity implements OnMapReadyCallback
                                                            , GoogleMap.OnMapClickListener
                                                            , AdapterView.OnItemClickListener{
    ArrayList<HashMap<String,String>> alStore;
    SupportMapFragment mapFragment;
    GoogleMap map;
    ListView listView;
    FloatingActionButton fab;
    RealmResults<Store> rrStore;
    MarkerOptions marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        alStore = new ArrayList<HashMap<String, String>>();
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                alStore,
                R.layout.list_item,
                new String[]{"s", "p+a"},
                new int[]{R.id.item_name, R.id.item_description}
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        map = mapFragment.getMap();
        populateStoreList();
        map.setOnMapClickListener(this);
        marker = new MarkerOptions();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.show();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(getApplicationContext(), ActivityAdd.class);
                startActivity(intentAdd);
                finish();
            }
        });
    }


        //handleIntent(getIntent());

    /*@Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }*/

    public void populateStoreList() {
        HashMap<String,String> tempStore;
        StoreRepository storeRepository = new StoreRepository();
        rrStore = storeRepository.getStoreAll();
        for (int i = 0; i < rrStore.size(); i++) {
            tempStore = new HashMap<String, String>();
            tempStore.put("s", getString(R.string.adapter_store) + rrStore.get(i).getName());
            tempStore.put("p+a", getString(R.string.adapter_phone) + rrStore.get(i).getPhone()
                        + ", " + getString(R.string.adapter_address) + rrStore.get(i).getAddress());
            alStore.add(tempStore);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

        // Associate searchable configuration with the SearchView
        /*SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        return super.onCreateOptionsMenu(menu);*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(ActivityMain.this, "NON-WORK", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_location:
                LatLng latLngMenu = new LatLng(Preferences.getLatitude(this)
                                             , Preferences.getLongitude(this));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngMenu, 16));
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
        StoreRepository storeRepository = new StoreRepository();
        RealmResults<Store> r = storeRepository.getStoreAll();
        for (int i = 0; i < r.size(); i++) {
            map.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_store))
                    .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                    .position(new LatLng(r.get(i).getLatitude(),r.get(i).getLongitude()))
                    .title(r.get(i).getName()));
        }
        LatLng latLngNow = new LatLng(Preferences.getLatitude(this)
                                    , Preferences.getLongitude(this));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngNow, 12));
        map.getUiSettings().setZoomControlsEnabled(true);
    }


    @Override
    public void onMapClick(LatLng latLng) {
        Preferences.setStoreLatitude(getApplication(),(float)latLng.latitude);
        Preferences.setStoreLongitude(getApplication(),(float)latLng.longitude);
        LatLng latLngClick = new LatLng(Preferences.getStoreLatitude(this)
                                      , Preferences.getStoreLongitude(this));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngClick, 16));
        map.addMarker(marker.position(latLngClick));
    }

    @Override
    public void onItemClick (AdapterView<?> parent, View view, final int position, long id) {
        LatLng latLngItemClick = new LatLng(rrStore.get(position).getLatitude()
                                          , rrStore.get(position).getLongitude());
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngItemClick, 16));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton(R.string.dialog_button_ok
                                      , new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            builder.setNegativeButton(R.string.dialog_button_del, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    String currentId = rrStore.get(position).getId();
                    StoreRepository storeRepository = new StoreRepository();
                    storeRepository.deleteStoreById(currentId);
                    Toast.makeText(ActivityMain.this
                                 , "Store " + currentId + " is deleted!"
                                 , Toast.LENGTH_SHORT).show();
                    Intent intentMain = new Intent(getApplicationContext(), ActivityMain.class);
                    startActivity(intentMain);
                }
            });
            builder.setNeutralButton(R.string.dialog_button_edit, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent intentAdd = new Intent(getApplicationContext(), ActivityAdd.class);
                    String currentId = rrStore.get(position).getId();
                    intentAdd.putExtra(Preferences.getIntentExtra(),currentId);
                    startActivity(intentAdd);
                }
            });
        builder.setTitle(getString(R.string.adapter_store)
                         + " "
                         + rrStore.get(position).getName());
        builder.setMessage(getString(R.string.adapter_phone)
                           + " "
                           + rrStore.get(position).getPhone()
                           + "\n"
                           + getString(R.string.adapter_address)
                           + " "
                           + rrStore.get(position).getAddress()
                           + "\n"
                           + "...");
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}