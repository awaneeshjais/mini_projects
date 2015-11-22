package com.whs;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    final static int TIME_SPLASH = 2500;
    final static int TIME_REFRESH_SERVICES = 45;
    final static int DISTANCE_REFRESH_SERVICES = 1;

    final static String STORE_NAME = "storeName";
    final static String STORE_TIME = "storeTime";

    final static String FILE_NAME = "whs";
    final static String LOCATION_LATITUDE = "locLat";
    final static String LOCATION_LONGITUDE = "locLong";
    final static String FIRST_DAY_OF_WEEK = "firstDay";

    public static int getTimeSplash() {
        return TIME_SPLASH;
    }

    public static int getTimeRefreshServices() {
        return TIME_REFRESH_SERVICES;
    }

    public static int getDistanceRefreshServices() {
        return DISTANCE_REFRESH_SERVICES;
    }

    public static String getStoreName() {
        return STORE_NAME;
    }

    public static String getStoreTime() {
        return STORE_TIME;
    }

    private static SharedPreferences preferences;

    private static SharedPreferences getPreferences(Context context) {
        if (preferences == null) {
            preferences = context.getSharedPreferences(FILE_NAME, 0);
        }
        return preferences;
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }



    public static void setLatitude(Context context, Float data) {
        getEditor(context).putFloat(LOCATION_LATITUDE, data).commit();
    }

    public static float getLatitude(Context context) {
        return getPreferences(context).getFloat(LOCATION_LATITUDE, 0.0f);
    }

    public static void setLongitude(Context context, Float data) {
        getEditor(context).putFloat(LOCATION_LONGITUDE, data).commit();
    }

    public static float getLongitude(Context context) {
        return getPreferences(context).getFloat(LOCATION_LONGITUDE, 0.0f);
    }

    public static void setFirstDayOfWeek(Context context, String data) {
        getEditor(context).putString(FIRST_DAY_OF_WEEK, data).commit();
    }

    public static String getFirstDayOfWeek(Context context) {
        return getPreferences(context).getString(FIRST_DAY_OF_WEEK, "1");
    }

}
