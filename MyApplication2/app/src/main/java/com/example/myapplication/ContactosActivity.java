package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.adapters.ContactosAdapter;
import com.example.myapplication.models.Usuario;
import com.example.myapplication.services.InfoServices;
import com.example.myapplication.services.dataResponse.InfoResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactosActivity extends AppCompatActivity {

    public RecyclerView usuariosRecycleView;
    public List<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        this.usuariosRecycleView = findViewById(R.id.usuariosRecycleView);

        //this.cargarLista();


        Call<InfoResponse> respInfo = (new InfoServices()).getInfoServices();
        respInfo.enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                InfoResponse infoResponse = response.body();
                ArrayList<Usuario> contactosArrayList = new ArrayList<>();
                System.out.println("hola");
                for (int x = 0; x < infoResponse.data.size(); x++) {
                    contactosArrayList.add(new Usuario(infoResponse.data.get(x).getId(),
                            infoResponse.data.get(x).getNames(),
                            infoResponse.data.get(x).getUsername(),
                            infoResponse.data.get(x).getPassword(),
                            infoResponse.data.get(x).getRol(),
                            infoResponse.data.get(x).getCreated_at(),
                            infoResponse.data.get(x).getUpdated_at()));
                    System.out.println(infoResponse.data.get(x).getId());
                }
                usuarios = contactosArrayList;
                initData();
            }

            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
                System.out.println("ERROR: "+t.getMessage());
            }
        });

    }

    /*private void cargarLista() {
        ArrayList<Usuario> contactosArrayList = new ArrayList<>();
        contactosArrayList.add(new Usuario(1,"12345","test@","1","1","1","1"));

        Call<InfoResponse> respInfo = (new InfoServices()).getInfoServices();
        respInfo.enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                InfoResponse infoResponse = response.body();
                System.out.println("hola");
                for (int x = 0; x < infoResponse.data.size(); x++) {
                    contactosArrayList.add(new Usuario(infoResponse.data.get(x).getId(),
                            infoResponse.data.get(x).getNames(),
                            infoResponse.data.get(x).getUsername(),
                            infoResponse.data.get(x).getPassword(),
                            infoResponse.data.get(x).getRol(),
                            infoResponse.data.get(x).getCreated_at(),
                            infoResponse.data.get(x).getUpdated_at()));
                    System.out.println(infoResponse.data.get(x).getId());
                }



            }

            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {
                System.out.println("ERROR: "+t.getMessage());
            }
        });
        System.out.println(contactosArrayList);
        this.usuarios = contactosArrayList;

    }*/


    public void initData(){
        this.usuariosRecycleView.setHasFixedSize(true);
        this.usuariosRecycleView.setLayoutManager(new LinearLayoutManager(this));
        ContactosAdapter adapter = new ContactosAdapter(this.usuarios, this);
        this.usuariosRecycleView.setAdapter(adapter);
    }
}