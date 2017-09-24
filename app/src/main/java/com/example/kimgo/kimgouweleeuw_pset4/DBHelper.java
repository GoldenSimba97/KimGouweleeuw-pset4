package com.example.kimgo.kimgouweleeuw_pset4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kimgo on 24-9-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    // Static strings
    private static final String DATABASE_NAME = "ContactDB.db.";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NUMBER = "number";
    private static final String TABLE = "contactTable";

    // Constructor
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DB = "CREATE TABLE " + TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
                + " TEXT NOT NULL," + KEY_NUMBER + "TEXT NOT NULL)";
        db.execSQL(CREATE_DB);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

}
