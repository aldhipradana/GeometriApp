package com.example.geometriapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnProfile, btnPersegi, btnSegitiga, btnBalok, btnExit;

        sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btnProfile = findViewById(R.id.btnProfile);
        btnPersegi = findViewById(R.id.btnPersegi);
        btnSegitiga = findViewById(R.id.btnSegitiga);
        btnBalok = findViewById(R.id.btnBalok);
        btnExit = findViewById(R.id.btnExit);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        btnPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersegiActivity.class);
                startActivity(intent);
            }
        });

        btnSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SegitigaActivity.class);
                startActivity(intent);
            }
        });

        btnBalok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BalokActivity.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeApplication(v);
            }
        });


    }

    public void closeApplication(View view) {
        editor.clear();
        editor.commit();
        finish();
        moveTaskToBack(true);
    }
}
