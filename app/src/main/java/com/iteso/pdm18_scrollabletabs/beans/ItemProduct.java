package com.iteso.pdm18_scrollabletabs.beans;

import android.graphics.drawable.Drawable;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class ItemProduct {
    private String title;
    private String store;
    private String phone;
    private String address;
    private Drawable photo;


    public ItemProduct(String title, String store, String phone, String address, Drawable photo) {
        this.title = title;
        this.store = store;
        this.phone= phone;
        this.address= address;
        this.photo= photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", photo=" + photo +
                '}';
    }
}
