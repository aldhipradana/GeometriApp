package com.example.geometriapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText usname;
    private TextInputEditText uspwd;
    Button login;
    ImageButton close;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.btnLogin);
        close = findViewById(R.id.closeBtn);
        usname =  findViewById(R.id.txtUsername);
        uspwd = findViewById(R.id.txtPassword);

        sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        session = sharedPreferences.edit();

        sesssionChecker();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginChecker()){
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    Toast.makeText( getApplicationContext(),"Halo "+sharedPreferences.getString("myname", ""), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else{
                    Toast.makeText( getApplicationContext(), "Enter Correct Username and Password!", Toast.LENGTH_SHORT).show();
                    Snackbar failedLogin = Snackbar.make(findViewById(android.R.id.content), "Use Author's NIM for Username and Password!", Snackbar.LENGTH_LONG);
                    View view = failedLogin.getView();
                    FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
                    params.gravity = Gravity.TOP;
                    view.setLayoutParams(params);
                    failedLogin.show();
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeApplication(v);
            }
        });
    }

    public boolean loginChecker() {

        final String username = usname.getText().toString();
        final String password = uspwd.getText().toString();
        final String myUsername = "18101041";
        final String myPassword = "18101041";

        if ( ( username != null && username.length() >= 1 ) && ( password != null && password.length() >= 3 ) ){
            if (username.equals(myUsername) && password.equals(myPassword)){
                session.putString("usname", username);
                session.putString("myname", "Gede Aldhi Pradana");
                session.putBoolean("session", true);
                session.commit();
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }

    }

    public void sesssionChecker(){

        boolean mysession = sharedPreferences.getBoolean("session", false);

        if (mysession){
            Toast.makeText( getApplicationContext(),"Halo "+sharedPreferences.getString("myname", ""), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText( getApplicationContext(),"Silahkan Login", Toast.LENGTH_SHORT).show();
        }

    }

    public void closeApplication(View view) {
        finish();
        moveTaskToBack(true);
    }
}
