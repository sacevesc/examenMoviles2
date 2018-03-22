package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.iteso.pdm18_scrollabletabs.beans.City;
import com.iteso.pdm18_scrollabletabs.beans.Store;
import com.iteso.pdm18_scrollabletabs.beans.User;
import com.iteso.pdm18_scrollabletabs.database.CityControl;
import com.iteso.pdm18_scrollabletabs.database.DataBaseHandler;
import com.iteso.pdm18_scrollabletabs.database.StoreControl;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StartStores();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadUser();
                Intent intent;
                if(user.getIslogged()){
                    intent = new Intent(ActivitySplash.this,ActivityMain.class);
                }else {
                    intent = new Intent(ActivitySplash.this,ActivityLogin.class);
                }
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,3000);
    }

    private void StartStores() {
        DataBaseHandler dh = DataBaseHandler.getInstance(ActivitySplash.this);
        StoreControl storeControl = new StoreControl();
        ArrayList<Store> tiendas = storeControl.getStores(dh);
        Toast.makeText(ActivitySplash.this, "Obteniendo tiendas", Toast.LENGTH_SHORT).show();

        if (tiendas.size() == 0) añadirTiendas();
        Toast.makeText(ActivitySplash.this, tiendas.toString(), Toast.LENGTH_SHORT).show();

    }

    private void añadirTiendas() {
        Toast.makeText(ActivitySplash.this, "NO HAY", Toast.LENGTH_SHORT).show();
        StoreControl storeControl = new StoreControl();
        CityControl cityControl = new CityControl();
        City city1 = cityControl.getCityById(1, DataBaseHandler.getInstance(ActivitySplash.this));
        City city2 = cityControl.getCityById(2, DataBaseHandler.getInstance(ActivitySplash.this));
        City city3 = cityControl.getCityById(3, DataBaseHandler.getInstance(ActivitySplash.this));

        Store store1 = new Store(1, "Bestbuy", "33 123 4567", 0, 20.607360, -103.414886, city1);
        storeControl.addStore(store1, DataBaseHandler.getInstance(ActivitySplash.this));

        Store store2 = new Store(2, "San Juan", "35 323 3232", 1, 24.607360, -123.414886, city2);
        storeControl.addStore(store2, DataBaseHandler.getInstance(ActivitySplash.this));

        Store store3 = new Store(3, "Dell", "44 123 7653", 2, 28.607360, -921.414886, city3);
        storeControl.addStore(store3, DataBaseHandler.getInstance(ActivitySplash.this));

    }

    public User loadUser(){
        SharedPreferences sharedPreferences = getSharedPreferences("com.iteso.USER_PREFERENCES", MODE_PRIVATE);
        User user = new User();
        user.setName(sharedPreferences.getString("NAME", null));
        user.setPassword(sharedPreferences.getString("PWD", null));
        user.setIslogged(sharedPreferences.getBoolean("LOGGED", false));
        return user;
    }
}
