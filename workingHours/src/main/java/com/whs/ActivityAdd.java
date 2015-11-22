package com.whs;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

public class ActivityAdd extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
