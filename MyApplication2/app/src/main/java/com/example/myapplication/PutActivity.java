package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.models.Usuario;
import com.example.myapplication.services.InfoServices;
import com.example.myapplication.services.dataResponse.InfoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PutActivity extends AppCompatActivity {

    public Usuario usuario;

    private Button regresarBtn;
    private EditText idPut;
    private EditText namesPut;
    private EditText userPut;
    private EditText rolPut;
    private EditText creadoPut;
    private EditText actuaPut;
    private Button actualizarPut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put);

        this.regresarBtn = findViewById(R.id.regresarPut);

        this.regresarBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListadoActivity.class);
            startActivity(intent);
            finish();
        });


        Bundle infoU = this.getIntent().getExtras();
        ;
        this.idPut = findViewById(R.id.idPut);
        this.namesPut = findViewById(R.id.namesPut);
        this.userPut = findViewById(R.id.userPut);
        this.rolPut = findViewById(R.id.rolPut);
        this.creadoPut = findViewById(R.id.creadoPut);
        this.actuaPut = findViewById(R.id.actuaPut);
        this.actualizarPut = findViewById(R.id.actualizarPut);

        this.idPut.setText(String.valueOf(infoU.getInt("id")));
        this.namesPut.setText(infoU.getString("nombre"));
        this.userPut.setText(infoU.getString("usuario"));
        this.rolPut.setText(infoU.getString("rol"));
        this.creadoPut.setText(infoU.getString("creado"));
        this.actuaPut.setText(infoU.getString("actualizado"));

        this.actualizarPut.setOnClickListener(view -> {
            String id = String.valueOf(infoU.getInt("id"));
            String nom = namesPut.getText().toString();
            String unom = userPut.getText().toString();
            String urol = rolPut.getText().toString();


            Usuario usuario = new Usuario(Integer.parseInt(id),nom,unom,urol);

            Call<InfoResponse> respInfo = (new InfoServices()).putInfoServices(String.valueOf(infoU.getInt("id")),usuario);
            respInfo.enqueue(new Callback<InfoResponse>() {
                @Override
                public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                    InfoResponse infoResponse = response.body();
                    System.out.println("hola");





                }

                @Override
                public void onFailure(Call<InfoResponse> call, Throwable t) {
                    System.out.println("ERROR: "+t.getMessage());
                }
            });
        });



       /* Call<InfoResponse> respInfo = (new InfoServices()).putInfoServices(infoU.getInt("id"),usuario);
        respInfo.enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                InfoResponse infoResponse = response.body();
                System.out.println("hola");





            }

            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
                System.out.println("ERROR: "+t.getMessage());
            }
        });*/


    }

}