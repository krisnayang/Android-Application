package com.example.bluejackgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    TextView lblUsername;
    Button csgoBtn, sotBtn, forzaBtn, dlBtn, pubgBtn, pBtn, hamburger;

    int[] images = {R.drawable.csgo, R.drawable.dyinglight, R.drawable.forzahorizon, R.drawable.phasmophobia, R.drawable.pubg, R.drawable.seaofthieves};
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        lblUsername = findViewById(R.id.lblUsername);
//
//        Intent intent = getIntent();
//        lblUsername.setText(intent.getStringExtra("username"));
        lblUsername.setText(sp.getString("username", ""));


        viewFlipper = findViewById(R.id.carousel);

        for (int image: images
        ) {
            slideImages(image);
        }

        hamburger = findViewById(R.id.hamburger);
        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });
        csgoBtn = findViewById(R.id.csgoBtn);
        sotBtn = findViewById(R.id.sotBtn);
        forzaBtn = findViewById(R.id.forzaBtn);
        dlBtn = findViewById(R.id.dlBtn);
        pubgBtn = findViewById(R.id.pubgBtn);
        pBtn = findViewById(R.id.pBtn);

        csgoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "CS:Global Offensive";
                String description = "Counter-Strike: Global Offensive (CS: GO) expands upon the team-based action gameplay that it pioneered when it was launched 19 years ago. CS: GO features new maps, characters, weapons, and game modes, and delivers updated versions of the classic CS content (de_dust2, etc.).";
                String price = "10$";
                String year = "2012";

                Intent intent = new Intent(HomeActivity.this, DetailPageActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("description",description);
                intent.putExtra("price",price);
                intent.putExtra("year",year);
                startActivity(intent);
            }
        });
        sotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "Sea of Thieves";
                String description = "\n" +
                        "Sea of Thieves offers the essential pirate experience, from sailing and fighting to exploring and looting – everything you need to live the pirate life and become a legend in your own right. With no set roles, you have complete freedom to approach the world, and other players, however you choose.";
                String price = "50$";
                String year = "2018";

                Intent intent = new Intent(HomeActivity.this, DetailPageActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("description",description);
                intent.putExtra("price",price);
                intent.putExtra("year",year);
                startActivity(intent);
            }
        });
        forzaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "Forza Horizon 5";
                String description = "Blast off to the visually stunning, exhilarating Horizon Hot Wheels Park in the clouds high above Mexico. Race 10 amazing new cars on the fastest, most extreme tracks ever devised. Design, build, and share your own Hot Wheels adventure. Requires Forza Horizon 5 game, sold separately";
                String price = "40$";
                String year = "2021";

                Intent intent = new Intent(HomeActivity.this, DetailPageActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("description",description);
                intent.putExtra("price",price);
                intent.putExtra("year",year);
                startActivity(intent);
            }
        });
        dlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "Dying Lights 2";
                String description = "The virus won and civilization has fallen back to the Dark Ages. The City, one of the last human settlements, is on the brink of collapse. Use your agility and combat skills to survive, and reshape the world. Your choices matter.";
                String price = "$ 50";
                String year = "2022";

                Intent intent = new Intent(HomeActivity.this, DetailPageActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("description",description);
                intent.putExtra("price",price);
                intent.putExtra("year",year);
                startActivity(intent);
            }
        });
        pubgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "PUBG:Battlegrounds";
                String description = "Play PUBG: BATTLEGROUNDS for free. Land on strategic locations, loot weapons and supplies, and survive to become the last team standing across various, diverse Battlegrounds. Squad up and join the Battlegrounds for the original Battle Royale experience that only PUBG: BATTLEGROUNDS can offer.";
                String price = "20$";
                String year = "2017";

                Intent intent = new Intent(HomeActivity.this, DetailPageActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("description",description);
                intent.putExtra("price",price);
                intent.putExtra("year",year);
                startActivity(intent);
            }
        });
        pBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "Phasmophobia";
                String description = "Every day, millions of players worldwide enter battle as one of over a hundred Dota heroes. And no matter if it's their 10th hour of play or 1,000th, there's always something new to discover. With regular updates that ensure a constant evolution of gameplay, features, and heroes, Dota 2 has taken on a life of its own.";
                String price = "5$";
                String year = "2013";

                Intent intent = new Intent(HomeActivity.this, DetailPageActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("description",description);
                intent.putExtra("price",price);
                intent.putExtra("year",year);
                startActivity(intent);
            }
        });
    }

    public void slideImages(int image){
        ImageView imageView = new ImageView(HomeActivity.this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(HomeActivity.this, android.R.anim.fade_in);
        viewFlipper.setOutAnimation(HomeActivity.this, android.R.anim.fade_out);
    }

}