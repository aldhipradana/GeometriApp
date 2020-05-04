package com.example.geometriapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SegitigaActivity extends AppCompatActivity {


    private TextInputEditText alasSegitiga, tinggiSegitiga;
    Button btnHitung;

    TextView hasilKll, hasilLuas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        alasSegitiga = findViewById(R.id.txtAlasSegitiga);
        tinggiSegitiga = findViewById(R.id.txtTinggiSegitiga);
        btnHitung = findViewById(R.id.btnHitungSegitiga);
        hasilKll = findViewById(R.id.hasilKllSegitiga);
        hasilLuas = findViewById(R.id.hasilLuasSegitiga);


        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtAlas = alasSegitiga.getText().toString();
                String txtTinggi = tinggiSegitiga.getText().toString();


                if (txtAlas != null && txtAlas.length() >= 1){

                    final Double alas = Double.parseDouble(txtAlas);
                    hasilKll.setText(Keliling(alas)+" cm");

                    if (txtTinggi != null && txtTinggi.length() >= 1){

                        final Double tinggi = Double.parseDouble(txtTinggi);
                        hasilLuas.setText(Luas(alas, tinggi)+" cm");

                    }else {

                        Toast.makeText( getApplicationContext(),"Silahkan lengkapi tinggi untuk menghitung Luas", Toast.LENGTH_SHORT).show();

                    }
                }else {

                    Toast.makeText( getApplicationContext(),"Silahkan Lengkapi Alas", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    Double Keliling( double a){
        a = 3 * a;
        return a;
    }


    Double Luas( double a, double t ){
        Double luas = (a * t)/2 ;
        return luas;
    }
}
