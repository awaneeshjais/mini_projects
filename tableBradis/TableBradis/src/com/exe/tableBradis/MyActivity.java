package com.exe.tableBradis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;

public class MyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void renderPageBradis(View view) {
        Intent intent = new Intent(this, PageBradis.class);
        startActivity(intent);
    }
    public void renderPageHistory(View view) {
        Intent intent = new Intent(this, PageHistory.class);
        startActivity(intent);
    }
    public void renderPageCalc(View view) {
        Intent intent = new Intent(this, PageCalc.class);
        startActivity(intent);
    }
}