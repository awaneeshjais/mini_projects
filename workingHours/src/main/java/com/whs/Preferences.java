package com.whs;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private final static int TIME_SPLASH = 2*1000;//seconds
    private final static int TIME_REFRESH_SERVICES = 30*1000;//seconds
    private final static int DISTANCE_REFRESH_SERVICES = 1;//metrs
    private final static String FILE_NAME = "whs";
    private final static String TAG = "WHS";
    private final static String DATA_BASE = "whs.realm";
    private final static String INTENT_EXTRA = "idstore";

    private final static String LOCATION_LATITUDE = "latitude";
    private final static String LOCATION_LONGITUDE = "longitude";
    private final static String STORE_LATITUDE = "storelatitude";
    private final static String STORE_LONGITUDE = "storelongitude";

    private final static int STORE_BAR_LEFT = 7;
    private final static int STORE_BAR_RIGHT = 23;
    private final static int STORE_IND_LEFT = 9;
    private final static int STORE_IND_RIGHT = 18;


    public static int getTimeSplash() {
        return TIME_SPLASH;
    }

    public static int getTimeRefreshServices() {
        return TIME_REFRESH_SERVICES;
    }

    public static int getDistanceRefreshServices() {
        return DISTANCE_REFRESH_SERVICES;
    }

    public static String getTag() {
        return TAG;
    }

    public static String getDataBase() {
        return DATA_BASE;
    }

    public static String getIntentExtra() {
        return INTENT_EXTRA;
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

    public static void setStoreLatitude(Context context, Float data) {
        getEditor(context).putFloat(STORE_LATITUDE, data).commit();
    }

    public static float getStoreLatitude(Context context) {
        return getPreferences(context).getFloat(STORE_LATITUDE, 0.0f);
    }

    public static void setStoreLongitude(Context context, Float data) {
        getEditor(context).putFloat(STORE_LONGITUDE, data).commit();
    }

    public static float getStoreLongitude(Context context) {
        return getPreferences(context).getFloat(STORE_LONGITUDE, 0.0f);
    }



    public static int getStoreBarLeft() {
        return STORE_BAR_LEFT;
    }

    public static int getStoreBarRight() {
        return STORE_BAR_RIGHT;
    }

    public static int getStoreIntLeft() {
        return STORE_IND_LEFT;
    }

    public static int getStoreIntRight() {
        return STORE_IND_RIGHT;
    }

}