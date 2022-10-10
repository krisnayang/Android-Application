package com.example.bluejackgames;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailPageActivity extends AppCompatActivity {
    Button hamburger, back, qtyBtn, okBtn;
    EditText etQty;
    TextView name, price, description, image,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        hamburger = findViewById(R.id.hamburger);
        back = findViewById(R.id.back);
        qtyBtn = findViewById(R.id.qtyBtn);
        etQty = findViewById(R.id.etQty);

        qtyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = 0;
                if (etQty.getText().toString().length() == 0)qty = 0;
                else qty = Integer.valueOf(etQty.getText().toString());
                if(qty < 1){
                    Dialog dialog = new Dialog(DetailPageActivity.this);
                    dialog.setContentView(R.layout.quantity_dialog);
                    dialog.show();
                    okBtn = dialog.findViewById(R.id.okBtn);
                    okBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                }else if (qty > 0){
                    Dialog dialog = new Dialog(DetailPageActivity.this);
                    dialog.setContentView(R.layout.buy_dialog);
                    dialog.show();
                    okBtn = dialog.findViewById(R.id.okBtn);
                    okBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Intent back = new Intent(DetailPageActivity.this, HomeActivity.class);
                            startActivity(back);
                        }
                    });
                }else {
                    Dialog dialog = new Dialog(DetailPageActivity.this);
                    dialog.setContentView(R.layout.quantity_dialog);
                    dialog.show();
                    okBtn = dialog.findViewById(R.id.okBtn);
                    okBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                }
            }
        });

        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailPageActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(DetailPageActivity.this, HomeActivity.class);
                startActivity(back);
            }
        });
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        year = findViewById(R.id.year);
        description = findViewById(R.id.description);
        image = findViewById(R.id.image);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        price.setText(intent.getStringExtra("price"));
        description.setText(intent.getStringExtra("description"));
        year.setText(intent.getStringExtra("year"));
        if(name.getText().equals("CS:Global Offensive"))
            image.setBackground(getDrawable(R.drawable.csgo));
        else if(name.getText().equals("Dying Lights 2"))
            image.setBackground(getDrawable(R.drawable.dyinglight));
        if(name.getText().equals("Forza Horizon 5"))
            image.setBackground(getDrawable(R.drawable.forzahorizon));
        if(name.getText().equals("Phasmophobia"))
            image.setBackground(getDrawable(R.drawable.phasmophobia));
        if(name.getText().equals("PUBG:Battlegrounds"))
            image.setBackground(getDrawable(R.drawable.pubg));
        if(name.getText().equals("Sea of Thieves"))
            image.setBackground(getDrawable(R.drawable.seaofthieves));
    }
}