package com.iteso.pdm18_scrollabletabs.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.pdm18_scrollabletabs.beans.City;

/**
 * Created by aceve on 21/03/2018.
 */

public class CityControl {
    public City getCityById(int idCity, DataBaseHandler dh) {
        City city = new City();

        String selectQuery =
                "SELECT C." + DataBaseHandler.KEY_CITY_ID + ","
                        + " C." + DataBaseHandler.KEY_CITY_NAME
                        + " FROM "
                        + DataBaseHandler.TABLE_CITY + " C"
                        + " WHERE C."
                        + DataBaseHandler.KEY_CITY_ID + "= " + idCity;
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        while (cursor.moveToNext()) {
            city.setId(cursor.getInt(0));
            city.setName(cursor.getString(1));
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        db = null;
        cursor = null;
        return city;
    }

}
