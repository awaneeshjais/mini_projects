package com.whs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActvity extends Activity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash);
        //http://stackoverflow.com/questions/5486789/how-do-i-make-a-splash-screen
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(getApplicationContext(),ActivityMain.class);
                startActivity(mainIntent);
                finish();
            }
        }, Preferences.getTimeSplash());
    }
}
