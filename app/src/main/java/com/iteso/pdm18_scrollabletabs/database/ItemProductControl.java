package com.iteso.pdm18_scrollabletabs.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.pdm18_scrollabletabs.beans.Category;
import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;

import java.util.ArrayList;

/**
 * Created by aceve on 18/03/2018.
 */

public class ItemProductControl {

    public void addItemProduct(ItemProduct product, DataBaseHandler dh) {
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHandler.KEY_PRODUCT_ID, product.getCode());
        values.put(DataBaseHandler.KEY_PRODUCT_NAME, product.getTitle());
        values.put(DataBaseHandler.KEY_PRODUCT_IMAGE, product.getImage());
        values.put(DataBaseHandler.KEY_PRODUCT_CATEGORY, product.getCategory().getId());
        db.insert("itemProduct", null, values);


        values.put(DataBaseHandler.KEY_STOREPRODUCT_ID, product.getCode());
        values.put(DataBaseHandler.KEY_STOREPRODUCT_PRODUCT, product.getTitle());
        values.put(DataBaseHandler.KEY_STOREPRODUCT_STORE, product.getStore().getId());
        db.insert("storeProduct", null, values);

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
        String selectQuery = "SELECT S." + DataBaseHandler.KEY_PRODUCT_ID + ","
                + "S." + DataBaseHandler.KEY_PRODUCT_NAME + ","
                + "S." + DataBaseHandler.KEY_PRODUCT_CATEGORY + ","
                + "S." + DataBaseHandler.KEY_PRODUCT_IMAGE + ","
                + "FROM "
                + DataBaseHandler.TABLE_PRODUCT + " S, "
                + DataBaseHandler.TABLE_CATEGORY + " C WHERE S."
                + DataBaseHandler.KEY_PRODUCT_CATEGORY + "= " + idCategory
                + " AND S." + DataBaseHandler.KEY_PRODUCT_CATEGORY
                + " = C." + DataBaseHandler.KEY_CATEGORY_ID;
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToNext()) {
            ItemProduct items = new ItemProduct();
            items.setTitle(cursor.getString(0));
            items.setImage(cursor.getInt(1));
            Category category = new Category();
            category.setId(cursor.getInt(2));
            category.setName(cursor.getString(3));
            items.setCategory(category);
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
