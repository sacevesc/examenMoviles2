package com.iteso.pdm18_scrollabletabs.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aceve on 18/03/2018.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    // Table names
    public static final String TABLE_CITY = "city";
    public static final String TABLE_CATEGORY = "category";
    public static final String TABLE_STORE = "store";
    public static final String TABLE_PRODUCT = "product";
    public static final String TABLE_STOREPRODUCT = "storeProduct";
    // Columns Cities
    public static final String KEY_CITY_ID = "idCity";
    public static final String KEY_CITY_NAME = "name";
    // Columns Category
    public static final String KEY_CATEGORY_ID = "idCategory";
    public static final String KEY_CATEGORY_NAME = "name";
    // Columns Store
    public static final String KEY_STORE_ID = "idStore";
    public static final String KEY_STORE_NAME = "name";
    public static final String KEY_STORE_PHONE = "phone";
    public static final String KEY_STORE_CITY = "idCity";
    public static final String KEY_STORE_THUMBNAIL = "thumbnail";
    public static final String KEY_STORE_LATTITUDE = "latitude";
    public static final String KEY_STORE_LONGITUDE = "longitude";
    // Columns Products
    public static final String KEY_PRODUCT_ID = "idProduct";
    public static final String KEY_PRODUCT_NAME = "name";
    public static final String KEY_PRODUCT_IMAGE = "image";
    public static final String KEY_PRODUCT_CATEGORY = "idCategory";
    // Columns StoreProducts
    public static final String KEY_STOREPRODUCT_ID = "idStoreProduct";
    public static final String KEY_STOREPRODUCT_PRODUCT = "idProduct";
    public static final String KEY_STOREPRODUCT_STORE = "idStore";
    private static final String DATABASE_NAME = "MyProducts.db";
    private static final int DATABASE_VERSION = 1;
    public static int STOREPRODUCT_ID_COUNTER = 1;
    public static int PRODUCT_ID_COUNTER = 0;
    private static DataBaseHandler dataBaseHandler;

    private DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DataBaseHandler getInstance(Context context) {
        if (dataBaseHandler == null) {
            dataBaseHandler = new DataBaseHandler(context);
        }
        return dataBaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CITY_TABLE = "CREATE TABLE " + TABLE_CITY + "("
                + KEY_CITY_ID + " INTEGER PRIMARY KEY," + KEY_CITY_NAME + " TEXT)";
        db.execSQL(CREATE_CITY_TABLE);

        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY + "("
                + KEY_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_CATEGORY_NAME + " TEXT)";
        db.execSQL(CREATE_CATEGORY_TABLE);

        String CREATE_STORE_TABLE = "CREATE TABLE " + TABLE_STORE + "("
                + KEY_STORE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_STORE_NAME + " TEXT,"
                + KEY_STORE_PHONE + " TEXT,"
                + KEY_STORE_CITY + " INTEGER,"
                + KEY_STORE_THUMBNAIL + " INTEGER,"
                + KEY_STORE_LATTITUDE + " DOUBLE,"
                + KEY_STORE_LONGITUDE + " DOUBLE)";
        db.execSQL(CREATE_STORE_TABLE);

        String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "("
                + KEY_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PRODUCT_NAME + " TEXT,"
                + KEY_PRODUCT_IMAGE + " INTEGER,"
                + KEY_PRODUCT_CATEGORY + " INTEGER)";
        db.execSQL(CREATE_PRODUCT_TABLE);


        String CREATE_STOREPRODUCT_TABLE = "CREATE TABLE " + TABLE_STOREPRODUCT + "("
                + KEY_STOREPRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_STOREPRODUCT_PRODUCT + " INTEGER,"
                + KEY_STOREPRODUCT_STORE + " INTEGER)";
        db.execSQL(CREATE_STOREPRODUCT_TABLE);


        db.execSQL("INSERT INTO " + TABLE_CATEGORY + " (" + KEY_CATEGORY_NAME + ") VALUES ('TECHNOLOGY')");
        db.execSQL("INSERT INTO " + TABLE_CATEGORY + " (" + KEY_CATEGORY_NAME + ") VALUES ('HOME')");
        db.execSQL("INSERT INTO " + TABLE_CATEGORY + " (" + KEY_CATEGORY_NAME + ") VALUES ('ELECTRONICS')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ")VALUES ('Guadalajara')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ")VALUES ('Zapopan')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ") VALUES ('Tonala')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ") VALUES ('Tlajomulco')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ") VALUES ('New York')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ") VALUES ('Tokio')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ") VALUES ('Moscu')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_NAME + ") VALUES ('Berlin')");

        //db.execSQL("INSERT INTO " + TABLE_STOREPRODUCT + " (" + KEY_STOREPRODUCT_PRODUCT + "," + KEY_STOREPRODUCT_STORE + ") VALUES (2,1)");
       /* db.execSQL("INSERT INTO " + TABLE_STORE + " ("
                + KEY_STORE_NAME + "," + KEY_STORE_PHONE + "," + KEY_STORE_CITY + "," + KEY_STORE_THUMBNAIL + ","
                + KEY_STORE_LATTITUDE + "," + KEY_STORE_LONGITUDE + ") VALUES ('BESTBUY', '33 123 4567', 1, 0, 20.607360, -103.414886)");
        db.execSQL("INSERT INTO " + TABLE_STORE + " ("
                + KEY_STORE_NAME + "," + KEY_STORE_PHONE + "," + KEY_STORE_CITY + "," + KEY_STORE_THUMBNAIL + ","
                + KEY_STORE_LATTITUDE + "," + KEY_STORE_LONGITUDE + ") VALUES ('SAN JUAN', '22222222', 2, 1, 20.607360, -103.414886)");
        db.execSQL("INSERT INTO " + TABLE_STORE + " ("
                + KEY_STORE_NAME + "," + KEY_STORE_PHONE + "," + KEY_STORE_CITY + "," + KEY_STORE_THUMBNAIL + ","
                + KEY_STORE_LATTITUDE + "," + KEY_STORE_LONGITUDE + ") VALUES ('BESTBUY', '33 333 3333', 2, 2, 20.607360, -103.414886)");
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
