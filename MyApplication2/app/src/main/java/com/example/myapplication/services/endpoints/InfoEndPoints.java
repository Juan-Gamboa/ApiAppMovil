package com.example.myapplication.services.endpoints;

import com.example.myapplication.models.Usuario;
import com.example.myapplication.services.dataResponse.InfoResponse;
import com.example.myapplication.services.dataResponse.InfoResponseAll;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface InfoEndPoints {
    @Headers("code-app: 2022*01")
    @GET("api/users")
    Call<InfoResponse> getInfo();

    @Headers("code-app: 2022*01")
    @GET("api/users/{id}")
    Call<InfoResponseAll> getInfoList();

    @Headers("code-app: 2022*01")
    @POST("api/users")
    Call<InfoResponseAll> postInfo(@Body Usuario usuario);/*@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);*/

    @Headers("code-app: 2022*01")
    @PUT("api/users/{id}")
    Call<InfoResponseAll> updatePost(@Path("id") String id, @Body Usuario usuario);

    @Headers("code-app: 2022*01")
    @DELETE("api/users/{id}")
    Call<InfoResponseAll> deletePost(@Path("id") String id);/*@Path("id") long id);*/

}
