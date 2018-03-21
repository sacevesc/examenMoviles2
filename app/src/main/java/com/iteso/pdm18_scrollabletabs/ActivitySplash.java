package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.iteso.pdm18_scrollabletabs.beans.Store;
import com.iteso.pdm18_scrollabletabs.beans.User;
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
        Toast.makeText(ActivitySplash.this, "Se obtuvieron las tiendas", Toast.LENGTH_SHORT).show();

        if (tiendas.size() == 0) añadirTienda();
        Toast.makeText(ActivitySplash.this, tiendas.toString(), Toast.LENGTH_SHORT).show();

    }

    private void añadirTienda() {
        Toast.makeText(ActivitySplash.this, "NO HAY", Toast.LENGTH_SHORT).show();

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
