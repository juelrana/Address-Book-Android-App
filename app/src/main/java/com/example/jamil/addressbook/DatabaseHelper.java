package com.example.jamil.addressbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    static  final int DATABASE_VERSION=1;
    static  final  String DATABASE_NAME="address_book.db";
    static  final String TABLE_ADDRESS="address_info";
    static final String COL_ID="id";
    static final String COL_NAME="name";
    static final String COL_PHONENO="phoneNo";
    static final String COL_EMAIL="email";
    static final String COL_STREET="street";
    static final String COL_ZIP="zip";
    static final String COL_CITY="city";


    String CREATE_TABLE_ADDRESS=" CREATE TABLE " + TABLE_ADDRESS +
            " ( " + COL_ID + " INTEGER PRIMARY KEY," + COL_NAME + " TEXT," +COL_PHONENO + " TEXT," +COL_EMAIL + " TEXT," +
            COL_STREET + " TEXT," +COL_ZIP + " TEXT," + COL_CITY+ " TEXT )";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ADDRESS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
///
    }
}
