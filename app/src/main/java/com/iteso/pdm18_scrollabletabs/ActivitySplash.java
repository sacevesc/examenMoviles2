package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.iteso.pdm18_scrollabletabs.beans.User;
import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
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

    public User loadUser(){
        SharedPreferences sharedPreferences = getSharedPreferences("com.iteso.USER_PREFERENCES", MODE_PRIVATE);
        User user = new User();
        user.setName(sharedPreferences.getString("NAME", null));
        user.setPassword(sharedPreferences.getString("PWD", null));
        user.setIslogged(sharedPreferences.getBoolean("LOGGED", false));
        return user;
    }
}
