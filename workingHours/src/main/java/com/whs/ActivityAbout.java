package com.whs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.whs.model.StoreRepository;

public class ActivityAbout extends AppCompatActivity {
    TextView textViewDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textViewDB = (TextView) findViewById(R.id.textViewDB);
        textViewDB.setText(getString(R.string.splash_content_db1)
                        + " "
                        + String.valueOf(new StoreRepository().countStore())
                        + " "
                        + getString(R.string.splash_content_db2));
    }
}