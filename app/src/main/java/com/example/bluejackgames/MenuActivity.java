package com.example.bluejackgames;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button homeMenu, aboutMenu, logoutMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        homeMenu = findViewById(R.id.homeMenu);
        aboutMenu = findViewById(R.id.aboutMenu);
        logoutMenu = findViewById(R.id.logoutMenu);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        homeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MenuActivity.this, HomeActivity.class);
                startActivity(home);
            }
        });
        aboutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(MenuActivity.this, AboutActivity.class);
                startActivity(about);
            }
        });
        logoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(logout);
            }
        });
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.7), (int)(height));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.RIGHT;
        params.x = 0;
        getWindow().setAttributes(params);
    }
}