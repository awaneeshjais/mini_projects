package com.whs;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ActivityDescription extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
