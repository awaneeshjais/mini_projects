package com.whs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SplashActvity extends Activity {
    //TODO 1. настроить поиск
    //TODO 2. обработчик ранжебаров
    //TODO 3. дизайн + анимация
    //TODO https://github.com/edmodo/range-bar
    //TODO https://android-arsenal.com/details/1/1272
    //TODO https://github.com/yahoo/android-range-seek-bar
    //TODO https://android-arsenal.com/details/1/3025
    //TODO nhttp://stackoverflow.com/questions/8227073/using-numberpicker-widget-with-strings
    //TODO https://android-arsenal.com/details/1/1298

    RealmConfiguration realmConfig;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash);

        realmConfig = new RealmConfiguration
                .Builder(this)
                .name(Preferences.getDataBase())
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(getApplicationContext(),ActivityMain.class);
                startActivity(mainIntent);
                finish();
            }
        }, Preferences.getTimeSplash());
        Log.i(Preferences.getTag(), "SplashActvity");
    }
}
