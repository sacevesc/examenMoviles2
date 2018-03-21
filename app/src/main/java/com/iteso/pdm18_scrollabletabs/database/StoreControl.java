package com.iteso.pdm18_scrollabletabs.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.pdm18_scrollabletabs.beans.City;
import com.iteso.pdm18_scrollabletabs.beans.Store;

import java.util.ArrayList;

/**
 * Created by aceve on 18/03/2018.
 */

public class StoreControl {

    public void addStore(Store store, DataBaseHandler dh) {

        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHandler.KEY_STORE_ID, store.getId());
        values.put(DataBaseHandler.KEY_STORE_LATTITUDE, store.getLatitude());
        values.put(DataBaseHandler.KEY_STORE_LONGITUDE, store.getLongitude());
        values.put(DataBaseHandler.KEY_STORE_NAME, store.getName());
        values.put(DataBaseHandler.KEY_STORE_PHONE, store.getPhone());
        values.put(DataBaseHandler.KEY_STORE_THUMBNAIL, store.getThumbnail());
        values.put(DataBaseHandler.KEY_STORE_CITY, store.getCity().getId());
        values.put(DataBaseHandler.KEY_STORE_CITY, store.getCity().getName());


        db.insert("store", null, values);

        try {
            db.close();
        } catch (Exception e) {
        }
        db = null;
        values = null;
    }


    public void deleteStore(int idStore, DataBaseHandler dh) {
        SQLiteDatabase db = dh.getWritableDatabase();
        db.delete(DataBaseHandler.TABLE_STORE, DataBaseHandler.KEY_STORE_ID
                + " = ?", new String[]{String.valueOf(idStore)});
        try {
            db.close();
        } catch (Exception e) {
        }
        db = null;
    }

    public ArrayList<Store> getStores(DataBaseHandler dh) {
        ArrayList<Store> stores = new ArrayList<>();
        String select = "SELECT S." + DataBaseHandler.KEY_STORE_ID + ","
                + "S." + DataBaseHandler.KEY_STORE_LATTITUDE + ","
                + "S." + DataBaseHandler.KEY_STORE_LONGITUDE + ","
                + "S." + DataBaseHandler.KEY_STORE_NAME + ","
                + "S." + DataBaseHandler.KEY_STORE_PHONE + ","
                + "S." + DataBaseHandler.KEY_STORE_THUMBNAIL + ","
                + "C." + DataBaseHandler.KEY_CITY_ID + ","
                + "C." + DataBaseHandler.KEY_CITY_NAME + " FROM "
                + DataBaseHandler.TABLE_STORE + " S, "
                + DataBaseHandler.TABLE_CITY + " C WHERE S."
                + DataBaseHandler.KEY_STORE_CITY + " = C."
                + DataBaseHandler.KEY_CITY_ID;
        ;

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);

        if (cursor.moveToNext()) {
            Store store = new Store();
            store.setId(cursor.getInt(0));
            store.setLatitude(cursor.getDouble(1));
            store.setLongitude(cursor.getDouble(2));
            store.setName(cursor.getString(3));
            store.setPhone(cursor.getString(4));
            store.setThumbnail(cursor.getInt(5));
            City city = new City();
            city.setId(cursor.getInt(6));
            city.setName(cursor.getString(7));
            store.setCity(city);
            stores.add(store);
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        db = null;
        cursor = null;
        return stores;
    }


    public ArrayList<Store> getStoreById(int idStore, DataBaseHandler dh) {
        ArrayList<Store> stores = new ArrayList<>();

        String selectQuery = "SELECT S." + DataBaseHandler.KEY_STORE_ID + ","
                + "S." + DataBaseHandler.KEY_STORE_LATTITUDE + ","
                + "S." + DataBaseHandler.KEY_STORE_LONGITUDE + ","
                + "S." + DataBaseHandler.KEY_STORE_NAME + ","
                + "S." + DataBaseHandler.KEY_STORE_PHONE + ","
                + "S." + DataBaseHandler.KEY_STORE_THUMBNAIL + ","
                + "C." + DataBaseHandler.KEY_CITY_ID + ","
                + "C." + DataBaseHandler.KEY_CITY_NAME + " FROM "
                + DataBaseHandler.TABLE_STORE + " S, "
                + DataBaseHandler.TABLE_CITY + " C WHERE S."
                + DataBaseHandler.KEY_STORE_ID + "= " + idStore
                + " AND S." + DataBaseHandler.KEY_STORE_CITY
                + " = C." + DataBaseHandler.KEY_CITY_ID;
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToNext()) {
            Store store = new Store();
            store.setId(cursor.getInt(0));
            store.setLatitude(cursor.getDouble(1));
            store.setLongitude(cursor.getDouble(2));
            store.setName(cursor.getString(3));
            store.setPhone(cursor.getString(4));
            store.setThumbnail(cursor.getInt(5));
            City city = new City();
            city.setId(cursor.getInt(6));
            city.setName(cursor.getString(7));
            store.setCity(city);
            stores.add(store);
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        db = null;
        cursor = null;
        return stores;
    }


}
/*
    public int updateStore(Store store, DataBaseHandler dh) {
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHandler.KEY_STORE_CITY, store.getCity().getId());
        values.put(DataBaseHandler.KEY_STORE_LATTITUDE, store.getLatitude());
        values.put(DataBaseHandler.KEY_STORE_LONGITUDE, store.getLongitude());
        values.put(DataBaseHandler.KEY_STORE_NAME, store.getName());
        values.put(DataBaseHandler.KEY_STORE_PHONE, store.getPhone());
        values.put(DataBaseHandler.KEY_STORE_THUMBNAIL, store.getThumbnail());
    // Updating row
        int count = db.update(DataBaseHandler.TABLE_STORE, values,
                DataBaseHandler.KEY_STORE_ID + " = ?",
                new String[]{String.valueOf(store.getId())});
        try {
            db.close();
        } catch (Exception e) {
        }
        db = null;
        return count;
    }
*/