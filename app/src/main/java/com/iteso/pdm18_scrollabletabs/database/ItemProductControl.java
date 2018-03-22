package com.iteso.pdm18_scrollabletabs.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.pdm18_scrollabletabs.beans.Category;
import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;
import com.iteso.pdm18_scrollabletabs.beans.Store;

import java.util.ArrayList;

/**
 * Created by aceve on 18/03/2018.
 */

public class ItemProductControl {

    public void addItemProduct(ItemProduct product, DataBaseHandler dh) {

        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHandler.KEY_PRODUCT_ID, DataBaseHandler.PRODUCT_ID_COUNTER);
        values.put(DataBaseHandler.KEY_PRODUCT_NAME, product.getTitle());
        values.put(DataBaseHandler.KEY_PRODUCT_IMAGE, product.getImage());
        values.put(DataBaseHandler.KEY_PRODUCT_CATEGORY, product.getCategory().getId());
        db.insert(DataBaseHandler.TABLE_PRODUCT, null, values);
        DataBaseHandler.PRODUCT_ID_COUNTER++;
        //////////////
        values = new ContentValues();
        values.put(DataBaseHandler.KEY_STOREPRODUCT_ID, DataBaseHandler.STOREPRODUCT_ID_COUNTER);
        values.put(DataBaseHandler.KEY_STOREPRODUCT_PRODUCT, product.getCode());
        values.put(DataBaseHandler.KEY_STOREPRODUCT_STORE, product.getStore().getId());
        db.insert(DataBaseHandler.TABLE_STOREPRODUCT, null, values);
        DataBaseHandler.STOREPRODUCT_ID_COUNTER++;
        ///////////
        try {
            db.close();
        } catch (Exception e) {
        }
        db = null;
        values = null;

    }

    private void addStoreProduct(ItemProduct product, DataBaseHandler dh) {
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        //String select = "SELECT "+ DataBaseHandler.KEY_PRODUCT_ID + " FROM " + DataBaseHandler.TABLE_PRODUCT + " WHERE "+
        values.put(DataBaseHandler.KEY_STOREPRODUCT_ID, DataBaseHandler.STOREPRODUCT_ID_COUNTER);
        values.put(DataBaseHandler.KEY_STOREPRODUCT_PRODUCT, product.getCode());
        values.put(DataBaseHandler.KEY_STOREPRODUCT_STORE, product.getStore().getId());
        db.insert(DataBaseHandler.TABLE_STOREPRODUCT, null, values);
        DataBaseHandler.STOREPRODUCT_ID_COUNTER++;
        try {
            db.close();
        } catch (Exception e) {
        }
        db = null;
        values = null;

    }


    public void deleteProduct(int idProduct, DataBaseHandler dh) {
        SQLiteDatabase db = dh.getWritableDatabase();
        db.delete(DataBaseHandler.TABLE_PRODUCT, DataBaseHandler.KEY_PRODUCT_ID
                + " = ?", new String[]{String.valueOf(idProduct)});
        try {
            db.close();
        } catch (Exception e) {
        }
        db = null;
    }


    public ArrayList<ItemProduct> getItemProductsByCategory(int idCategory, DataBaseHandler dh) {
        ArrayList<ItemProduct> itemProducts = new ArrayList<>();
        String selectQuery =
                "SELECT S." + DataBaseHandler.KEY_PRODUCT_ID + ","
                + "S." + DataBaseHandler.KEY_PRODUCT_NAME + ","
                + "S." + DataBaseHandler.KEY_PRODUCT_CATEGORY + ","
                        + "C." + DataBaseHandler.KEY_CATEGORY_NAME + ","
                        + "S." + DataBaseHandler.KEY_PRODUCT_IMAGE + ","
                        + "T." + DataBaseHandler.KEY_STOREPRODUCT_ID
                + " FROM "
                + DataBaseHandler.TABLE_PRODUCT + " S, "
                        + DataBaseHandler.TABLE_CATEGORY + " C, "
                        + DataBaseHandler.TABLE_STOREPRODUCT + " T "
                        + " WHERE S."
                + DataBaseHandler.KEY_PRODUCT_CATEGORY + "= " + idCategory
                + " AND S." + DataBaseHandler.KEY_PRODUCT_CATEGORY
                        + " = C." + DataBaseHandler.KEY_CATEGORY_ID
                        + " AND T." + DataBaseHandler.KEY_STOREPRODUCT_PRODUCT
                        + " = S." + DataBaseHandler.KEY_PRODUCT_ID;
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            ItemProduct items = new ItemProduct();
            items.setCode(cursor.getInt(0));
            items.setTitle(cursor.getString(1));
            items.setImage(cursor.getInt(4));

            Category category = new Category();
            category.setId(cursor.getInt(2));
            category.setName(cursor.getString(3));
            items.setCategory(category);

            Store store = new Store();
            StoreControl storeControl = new StoreControl();
            store.setId(cursor.getInt(5));
            store = storeControl.getStoreById(store.getId(), dh);
            items.setStore(store);
            itemProducts.add(items);
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        db = null;
        cursor = null;

        return itemProducts;
    }

}
