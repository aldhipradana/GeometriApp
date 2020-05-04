package com.example.geometriapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class BalokActivity extends AppCompatActivity {

    private TextInputEditText panjangBalok, lebarBalok, tinggiBalok;
    Button btnHitung;

    TextView hasilVolume, hasilLuasAlas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balok);

        panjangBalok = findViewById(R.id.txtPanjangBalok);
        lebarBalok = findViewById(R.id.txtLebarBalok);
        tinggiBalok = findViewById(R.id.txtTinggiBalok);
        btnHitung = findViewById(R.id.btnHitungBalok);
        hasilVolume = findViewById(R.id.hasilVolumeBalok);
        hasilLuasAlas = findViewById(R.id.hasilLABalok);


        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtPanjang = panjangBalok.getText().toString();
                String txtLebar = lebarBalok.getText().toString();
                String txtTinggi = tinggiBalok.getText().toString();


                if ((txtPanjang != null && txtPanjang.length() >= 1) && (txtLebar != null && txtLebar.length() >= 1)){

                    final Double panjang = Double.parseDouble(txtPanjang);
                    final Double lebar = Double.parseDouble(txtLebar);
                    hasilLuasAlas.setText(LuasAlas(panjang, lebar)+" cm");

                    if (txtTinggi != null && txtTinggi.length() >= 1){

                        final Double tinggi = Double.parseDouble(txtTinggi);
                        hasilVolume.setText(Volume(LuasAlas(panjang, lebar), tinggi)+" cm");

                    }else {

                        Toast.makeText( getApplicationContext(),"Silahkan lengkapi tinggi untuk menghitung Volume", Toast.LENGTH_SHORT).show();

                    }
                }else {

                    Toast.makeText( getApplicationContext(),"Silahkan Lengkapi Panjang dan Lebar", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    Double Volume( double la, double t){
        Double vol = la * t;
        return vol;
    }


    Double LuasAlas( double p, double l ){
        Double luas = p * l;
        return luas;
    }
}
