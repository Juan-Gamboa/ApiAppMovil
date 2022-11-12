package com.example.myapplication.services;

import com.example.myapplication.models.Usuario;
import com.example.myapplication.services.dataResponse.InfoResponse;
import com.example.myapplication.services.dataResponse.InfoResponseAll;
import com.example.myapplication.services.endpoints.InfoEndPoints;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoServices {

    private Retrofit getRetroFit(){
        return new Retrofit.Builder()
                .baseUrl("http://192.168.0.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<InfoResponse> getInfoServices(){
        Call<InfoResponse> call = this.getRetroFit().create(InfoEndPoints.class).getInfo();
        return call;
    }
    public Call<InfoResponseAll>postInfoServices(Usuario usuario){
        Call<InfoResponseAll> call = this.getRetroFit().create(InfoEndPoints.class).postInfo(usuario);
        return call;
    }

    public Call<InfoResponseAll>putInfoServices(String id, Usuario usuario){
        Call<InfoResponseAll> call = this.getRetroFit().create(InfoEndPoints.class).updatePost(id,usuario);
        return call;
    }
    public Call<InfoResponseAll> deleteInfoService(String id) {
        Call<InfoResponseAll> call = this.getRetroFit().create(InfoEndPoints.class).deletePost(id);
        return call;
    }


}
