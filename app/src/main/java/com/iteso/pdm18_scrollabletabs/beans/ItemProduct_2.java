package com.iteso.pdm18_scrollabletabs.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oscarvargas on 26/02/18.
 */

public class ItemProduct_2 implements Parcelable {
    public static final Creator<ItemProduct> CREATOR = new Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel source) {
            return new ItemProduct(source);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };
    private String title;
    private String store;
    private String phone;
    private String address;
    private int photo;
    private int code;
    private int store_photo;

    public ItemProduct_2(String title, String store, String phone, String address, int photo, int code, int store_photo) {
        this.title = title;
        this.store = store;
        this.phone = phone;
        this.address = address;
        this.photo = photo;
        this.code = code;
        this.store_photo = store_photo;
    }

    public ItemProduct_2() {
        this.title = "";
        this.store = "";
        this.phone = "";
        this.address = "";
        this.photo = 0;
        //this.store_photo = 0;
    }

    protected ItemProduct_2(Parcel in) {
        this.title = in.readString();
        this.store = in.readString();
        this.phone = in.readString();
        this.address = in.readString();
        this.photo = in.readInt();
        this.code = in.readInt();
        //this.store_photo = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.store);
        dest.writeString(this.phone);
        dest.writeString(this.address);
        dest.writeInt(this.photo);
        dest.writeInt(this.code);
        //dest.writeInt(this.store_photo);
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

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStore_photo() {
        return store_photo;
    }

    public void setStore_photo(int store_photo) {
        this.store_photo = store_photo;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", code=" + code +
                '}';
    }
}
