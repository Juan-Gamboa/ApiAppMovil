package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button regresarBtn;
    private EditText usuarioTxt;
    private EditText pwdTxt;
    private Button iniciarSesionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.usuarioTxt = findViewById(R.id.usuarioTxt);
        this.pwdTxt = findViewById(R.id.pwdTxt);
        this.iniciarSesionBtn = findViewById(R.id.iniciarSesionBtn);

        this.iniciarSesionBtn.setOnClickListener(view -> {
            System.out.println(this.usuarioTxt.getText());
        });

        this.regresarBtn = findViewById(R.id.regresarBtn);
        this.regresarBtn.setOnClickListener(view -> {
            //Intent intent = new Intent(this, MainActivity.class);
            //startActivity(intent);
            finish();
        });
    }
}