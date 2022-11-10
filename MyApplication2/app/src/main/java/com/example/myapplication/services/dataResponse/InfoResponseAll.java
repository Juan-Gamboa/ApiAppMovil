package com.example.myapplication.services.dataResponse;

import com.example.myapplication.services.models.InfoApi;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InfoResponseAll {
    @SerializedName("date") public Object date;
    @SerializedName("data") public InfoApi data;
}
