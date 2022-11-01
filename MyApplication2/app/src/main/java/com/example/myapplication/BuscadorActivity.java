package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.services.InfoServices;
import com.example.myapplication.services.dataResponse.InfoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuscadorActivity extends AppCompatActivity {

    private Button btnBuscar;
    private EditText buscarTxt;
    public String datoB;
    public String datoJ;
    public boolean encontrado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        this.btnBuscar = findViewById(R.id.btnBuscar);
        this.buscarTxt = findViewById(R.id.buscarTxt);


        this.btnBuscar.setOnClickListener(view -> {
            System.out.println(this.buscarTxt.getText());
            datoB = this.buscarTxt.getText().toString();
            System.out.println(datoB);
            Call<InfoResponse> respInfo = (new InfoServices()).getInfoServices();
            respInfo.enqueue(new Callback<InfoResponse>() {
                @Override
                public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                    InfoResponse infoResponse = response.body();
                    System.out.println("hola");

                    for (int x = 0; x < infoResponse.data.size(); x++) {
                        System.out.println("entre a for");
                        System.out.println(x);
                        datoJ = infoResponse.data.get(x).getNames();
                        System.out.println(datoJ);
                        if (datoB.equals(datoJ)) {
                            encontrado = true;
                            System.out.println("si busque");
                            System.out.println(infoResponse.data.get(x).getNames() +" "+infoResponse.data.get(x).getUsername()+" "+infoResponse.data.get(x).getPassword()
                                    +" "+infoResponse.data.get(x).getRol());
                            Toast.makeText(getApplicationContext(),"Datos encontrados: "+infoResponse.data.get(x).getNames() +" "+infoResponse.data.get(x).getUsername()+" "+infoResponse.data.get(x).getPassword()
                                    +" "+infoResponse.data.get(x).getRol(),Toast.LENGTH_LONG).show();
                            break;
                        }else{
                            encontrado = false;
                            System.out.println("No existe Información");
                        }
                        if (x==infoResponse.data.size()){
                            System.out.println("entre a verficar");
                            Toast.makeText(getApplicationContext(),"El dato deseado no existe",Toast.LENGTH_LONG).show();
                            break;

                        }

                    }
                }

                @Override
                public void onFailure(Call<InfoResponse> call, Throwable t) {
                    System.out.println("ERROr: "+t.getMessage());
                }
            });
        });



    }
}