package com.whs.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DBHelperStore extends SQLiteOpenHelper implements IDBHelperStore{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "storedb";
    private static final String DATABASE_TEBLE = "store";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME_STORE = "nameStore";
    private static final String KEY_TELEFON = "telefon";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_LOC_LATITUDE = "locLatitude";
    private static final String KEY_LOC_LONGITUDE = "locLongitude";
    //private static final String KEY_TIME_ID = "time_id";
    private static final String KEY_IS24HOURS = "is24hours";
    private static final String KEY_START1 = "start1";
    private static final String KEY_END1 = "end1";
    private static final String KEY_START2 = "start2";
    private static final String KEY_END2 = "end2";
    private static final String KEY_START3 = "start3";
    private static final String KEY_END3 = "end3";
    private static final String KEY_START4 = "start4";
    private static final String KEY_END4 = "end4";
    private static final String KEY_START5 = "start5";
    private static final String KEY_END5 = "end5";
    private static final String KEY_START6 = "start6";
    private static final String KEY_END6 = "end6";
    private static final String KEY_START7 = "start7";
    private static final String KEY_END7 = "end7";

    public DBHelperStore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DATABASE_TEBLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME_STORE + " TEXT,"
                + KEY_TELEFON + " TEXT,"
                + KEY_ADDRESS + " TEXT,"
                + KEY_LOC_LATITUDE + " DOUBLE,"
                + KEY_LOC_LONGITUDE + " DOUBLE,"
                //+ KEY_TIME_ID + " ,"
                + KEY_IS24HOURS + " BOOLEAN,"
                + KEY_START1 + " TEXT,"
                + KEY_END1 + " TEXT,"
                + KEY_START2 + " TEXT,"
                + KEY_END2 + " TEXT,"
                + KEY_START3 + " TEXT,"
                + KEY_END3 + " TEXT,"
                + KEY_START4 + " TEXT,"
                + KEY_END4 + " TEXT,"
                + KEY_START5 + " TEXT,"
                + KEY_END5 + " TEXT,"
                + KEY_START6 + " TEXT,"
                + KEY_END6 + " TEXT,"
                + KEY_START7 + " TEXT,"
                + KEY_END7 + " TEXT,"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TEBLE);
        onCreate(db);
    }

    @Override
    public void addStore(Store store) {

    }

    @Override
    public Store getStore(int id) {
        return null;
    }

    @Override
    public List<Store> getAllStores() {
        return null;
    }

    @Override
    public int getStoresCount() {
        return 0;
    }

    @Override
    public int updateStore(Store store) {
        return 0;
    }

    @Override
    public void deleteStore(Store store) {

    }

    @Override
    public void deleteAllStores() {

    }


}
