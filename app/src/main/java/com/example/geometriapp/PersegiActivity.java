package com.example.geometriapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class PersegiActivity extends AppCompatActivity {


    private TextInputEditText sisiPersegi;
    Button btnHitung;

    TextView hasilKll, hasilLuas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);

        sisiPersegi = findViewById(R.id.txtSisiPersegi);
        btnHitung = findViewById(R.id.btnHitungPersegi);
        hasilKll = findViewById(R.id.hasilKllPersegi);
        hasilLuas = findViewById(R.id.hasilLuasPersegi);


        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtSisi = sisiPersegi.getText().toString();

                if (txtSisi != null && txtSisi.length() >= 1){

                    final Integer sisi = Integer.parseInt(txtSisi);
                    hasilKll.setText(Keliling(sisi)+" cm");
                    hasilLuas.setText(Luas(sisi)+" cm");

                }else {
                    Toast.makeText( getApplicationContext(),"Silahkan Lengkapi Sisi", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    Integer Keliling( int s ){
        s = 4 * s;
        return s;
    }


    Integer Luas( int s ){
        s = s * s;
        return s;
    }
}
