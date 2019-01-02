package com.example.jamil.addressbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Jamil on 3/17/2016.
 */
public class AddressManager {
    private Address address;
    private DatabaseHelper helper;
    private SQLiteDatabase database;

    public AddressManager(Context context) {
        helper = new DatabaseHelper(context);
    }

    private void open() {
        database = helper.getWritableDatabase();

    }

    private void close() {
        helper.close();
    }

    public boolean addContact(Address address) {
        this.open();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_NAME, address.getName());
        contentValues.put(DatabaseHelper.COL_PHONENO, address.getPhoneNo());
        contentValues.put(DatabaseHelper.COL_EMAIL, address.getEmail());
        contentValues.put(DatabaseHelper.COL_STREET, address.getStreet());
        contentValues.put(DatabaseHelper.COL_ZIP, address.getZip());
        contentValues.put(DatabaseHelper.COL_CITY, address.getCity());

        long inserted = database.insert(DatabaseHelper.TABLE_ADDRESS, null, contentValues);
        this.close();

        if (inserted > 0) {
            return true;
        } else return false;


    }

    public Address getContact(int id) {

        this.open();

        Cursor cursor = database.query(DatabaseHelper.TABLE_ADDRESS, new String[]{DatabaseHelper.COL_ID, DatabaseHelper.COL_NAME,
                        DatabaseHelper.COL_PHONENO, DatabaseHelper.COL_EMAIL, DatabaseHelper.COL_STREET, DatabaseHelper.COL_ZIP, DatabaseHelper.COL_CITY},
                DatabaseHelper.COL_ID + "= " + id, null, null, null, null);


        cursor.moveToFirst();

        int mid = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
        String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
        String phoneNo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PHONENO));
        String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EMAIL));
        String street = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_STREET));
        String zip = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ZIP));
        String city = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_CITY));

        address = new Address(mid, name, phoneNo, email, street, zip, city);
        this.close();

        return address;
    }

    public ArrayList<Address> getAllContacts() {

        this.open();
        ArrayList<Address> contactList = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHelper.TABLE_ADDRESS, null, null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {

                int mid = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
                String phoneNo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PHONENO));
                String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EMAIL));
                String street = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_STREET));
                String zip = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ZIP));
                String city = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_CITY));

                address = new Address(mid, name, phoneNo, email, street, zip, city);
                contactList.add(address);
                cursor.moveToNext();
            }
        }
        this.close();
        return contactList;

    }
    public boolean updateContact(int id, Address address) {

        this.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_NAME, address.getName());
        contentValues.put(DatabaseHelper.COL_PHONENO, address.getPhoneNo());
        contentValues.put(DatabaseHelper.COL_EMAIL, address.getEmail());
        contentValues.put(DatabaseHelper.COL_STREET, address.getStreet());
        contentValues.put(DatabaseHelper.COL_ZIP, address.getZip());
        contentValues.put(DatabaseHelper.COL_CITY, address.getCity());


        int updated = database.update(DatabaseHelper.TABLE_ADDRESS, contentValues, DatabaseHelper.COL_ID + " = " + id, null);
        this.close();
        if (updated > 0) {
            return true;
        } else return false;
    }
    public boolean deleteContact(int id) {
        this.open();
        int deleted = database.delete(DatabaseHelper.TABLE_ADDRESS, DatabaseHelper.COL_ID + "= " + id, null);
        this.close();
        if (deleted > 0) {
            return true;
        } else return false;

    }


}
