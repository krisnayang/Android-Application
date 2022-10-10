package com.example.bluejackgames;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, okBtn;
    EditText etUsername, etPassword;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if(username.isEmpty()){
                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.dialog);
                    dialog.show();
                    okBtn = dialog.findViewById(R.id.okBtn);
                    okBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                }else if(password.isEmpty()){
                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.password_dialog);
                    dialog.show();
                    okBtn = dialog.findViewById(R.id.okBtn);
                    okBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                }else if(username.length()<3){
                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.username_dialog);
                    dialog.show();
                    okBtn = dialog.findViewById(R.id.okBtn);
                    okBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                }else if(username.length()>=3 && !password.isEmpty()){
                    SharedPreferences.Editor editor = sp.edit();

                    editor.putString("username", username);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("username",username);
                    startActivity(intent);
                }
            }
        });
    }
}