package com.whs.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperWorkTime extends SQLiteOpenHelper implements IDBHelperWorkTime {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "worktime";


    public DBHelperWorkTime(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void addWorkTime(WorkTime workTime) {

    }

    @Override
    public Store getWorkTime(int id) {
        return null;
    }

    @Override
    public int updateWorkTime(WorkTime workTime) {
        return 0;
    }

    @Override
    public void deleteWorkTime(WorkTime workTime) {

    }


}
