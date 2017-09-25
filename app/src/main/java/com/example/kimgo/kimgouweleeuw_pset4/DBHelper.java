package com.example.kimgo.kimgouweleeuw_pset4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by kimgo on 24-9-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    // Static strings
    private static final String DATABASE_NAME = "ContactDB.db";
    private static final int DATABASE_VERSION = 2;
    private static final String KEY_ID = "_id";
//    private static final String KEY_NAME = "name";
//    private static final String KEY_NUMBER = "number";
    private static final String KEY_TITLE = "title";
    private static final String KEY_COMPLETED = "completed";
    private static final String TABLE = "contactTable";

    // Constructor
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DB = "CREATE TABLE " + TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_TITLE
                + " TEXT NOT NULL," + KEY_COMPLETED + "TEXT NOT NULL)";
        db.execSQL(CREATE_DB);
        Log.d("hello", "hello");
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String CREATE_DB = "CREATE TABLE " + TABLE + "("
//                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
//                + " TEXT NOT NULL," + KEY_NUMBER + "TEXT NOT NULL)";
//        db.execSQL(CREATE_DB);
//    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public void create(Contact toDo) {
        SQLiteDatabase db = getWritableDatabase();
//        onUpgrade(db, 1, 2);
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, toDo.getTitle());
        values.put(KEY_COMPLETED, toDo.getCompleted());
        db.insert(TABLE, null, values);
        db.close();
    }

//    public void create(Contact contact) {
//        SQLiteDatabase db = getWritableDatabase();
//        onUpgrade(db, 1, 1);
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.getName());
//        values.put(KEY_NUMBER, contact.getNumber());
//        db.insert(TABLE, null, values);
//        db.close();
//    }

    public ArrayList<Contact> read() {
        SQLiteDatabase db = getReadableDatabase();

        // A list of costum objects to store our data
        ArrayList<Contact> toDos = new ArrayList<>();

        // Create a query to give to the cursor
        String query = "SELECT " + KEY_ID + ", " + KEY_TITLE + ", " + KEY_COMPLETED + " FROM " + TABLE;
        Cursor cursor = db.rawQuery(query, null);

        // Set cursor to the beginning of our database
        if (cursor.moveToFirst()) {
            do {
                // Add id, done-status and to-do from current row to to-do-list
                String title = cursor.getString(cursor.getColumnIndex(KEY_TITLE));
                int completed = cursor.getInt(cursor.getColumnIndex(KEY_COMPLETED));
                int id = cursor.getInt(cursor.getColumnIndex(KEY_ID));

                // Create a contact object with the newly retrieved data
                Contact toDo = new Contact(title, completed, id);
                toDos.add(toDo);
            }
            // While there is still a next entry
            while (cursor.moveToNext());
        }

        // Close the database and the cursor
        cursor.close();
        db.close();
        return toDos;
    }

//    public ArrayList<Contact> read() {
//        SQLiteDatabase db = getReadableDatabase();
//
//        // A list of costum objects to store our data
//        ArrayList<Contact> contacts = new ArrayList<>();
//
//        // Create a query to give to the cursor
//        String query = "SELECT " + KEY_ID + ", " + KEY_NAME + ", " + KEY_NUMBER + " FROM " + TABLE;
//        Cursor cursor = db.rawQuery(query, null);
//
//        // Set cursor to the beginning of our database
//        if (cursor.moveToFirst()) {
//            do {
//                // Add id, done-status and to-do from current row to to-do-list
//                String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
//                String number = cursor.getString(cursor.getColumnIndex(KEY_NUMBER));
//                int id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
//
//                // Create a contact object with the newly retrieved data
//                Contact contact = new Contact(name, number, id);
//                contacts.add(contact);
//            }
//            // While there is still a next entry
//            while (cursor.moveToNext());
//        }
//
//        // Close the database and the cursor
//        cursor.close();
//        db.close();
//        return contacts;
//    }

    public int update(Contact toDo) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, toDo.getTitle());
        values.put(KEY_COMPLETED, toDo.getCompleted());

        // Return whether it has succeeded or not
        return db.update(TABLE, values, KEY_ID + " = ? ", new String[] { String.valueOf(toDo.getID())});
    }

//    public int update(Contact contact) {
//        SQLiteDatabase db = getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.getName());
//        values.put(KEY_NUMBER, contact.getNumber());
//
//        // Return whether it has succeeded or not
//        return db.update(TABLE, values, KEY_ID + " = ? ", new String[] { String.valueOf(contact.getID())});
//    }

    public void delete(Contact toDo) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE, " " + KEY_ID + " = ? ", new String[] { String.valueOf(toDo.getID())});
        db.close();
    }

}
