package com.example.myapplication.services.endpoints;

import com.example.myapplication.services.dataResponse.InfoResponse;

import retrofit2.Call;
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
    @GET("api/users/{id}")
    Call<InfoResponse> getInfoList();

    @POST("/api/users")
    @FormUrlEncoded
    Call<InfoResponse> postInfo();/*@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);*/
    @PUT("api/users/{id}")
    @FormUrlEncoded
    Call<InfoResponse> updatePost();/*@Path("id") long id,
                          @Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") long userId);*/

    @DELETE("api/users/{id}")
    Call<InfoResponse> deletePost();/*@Path("id") long id);*/

}
