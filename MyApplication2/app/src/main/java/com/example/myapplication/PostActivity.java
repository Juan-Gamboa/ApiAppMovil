package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.models.Usuario;
import com.example.myapplication.services.InfoServices;
import com.example.myapplication.services.dataResponse.InfoResponse;
import com.example.myapplication.services.dataResponse.InfoResponseAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    private Button volverPost;
    private Button agregarPost;
    private EditText postName;
    private EditText postUser;
    private EditText postPassword;
    private EditText postRol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        this.agregarPost = findViewById(R.id.agregarPost);
        this.volverPost = findViewById(R.id.volverPost);
        this.postName = findViewById(R.id.postName);
        this.postUser = findViewById(R.id.postUser);
        this.postPassword = findViewById(R.id.postPassword);
        this.postRol = findViewById(R.id.postRol);

        this.volverPost.setOnClickListener(view -> {

            Intent intent = new Intent(this, ListadoActivity.class);
            startActivity(intent);
            finish();

        });

        this.agregarPost.setOnClickListener(view -> {
            String nombre = this.postName.getText().toString();
            String user = this.postUser.getText().toString();
            String pass = this.postPassword.getText().toString();


            Usuario usuario = new Usuario(nombre,user,pass,"admin");

            Call<InfoResponseAll> respInfo = (new InfoServices()).postInfoServices(usuario);
            respInfo.enqueue(new Callback<InfoResponseAll>() {
                @Override
                public void onResponse(Call<InfoResponseAll> call, Response<InfoResponseAll> response) {
                    InfoResponseAll infoResponseAll = response.body();






                }

                @Override
                public void onFailure(Call<InfoResponseAll> call, Throwable t) {
                    System.out.println("ERROR: "+t.getMessage());
                }
            });
        });

    }
}