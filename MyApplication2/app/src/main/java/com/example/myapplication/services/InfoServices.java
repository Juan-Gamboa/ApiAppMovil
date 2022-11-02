package com.example.myapplication.services;

import com.example.myapplication.services.dataResponse.InfoResponse;
import com.example.myapplication.services.endpoints.InfoEndPoints;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoServices {

    private Retrofit getRetroFit(){
        return new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<InfoResponse> getInfoServices(){
        Call<InfoResponse> call = this.getRetroFit().create(InfoEndPoints.class).getInfo();
        return call;
    }
    public Call<InfoResponse>postInfoServices(){
        Call<InfoResponse> call = this.getRetroFit().create(InfoEndPoints.class).postInfo();
        return call;
    }

    public Call<InfoResponse>putInfoServices(){
        Call<InfoResponse> call = this.getRetroFit().create(InfoEndPoints.class).updatePost();
        return call;
    }


}
