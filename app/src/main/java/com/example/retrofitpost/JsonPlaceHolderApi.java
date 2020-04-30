package com.example.retrofitpost;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface JsonPlaceHolderApi {

    @GET("mahasiswa")
    Call<List<Post>> getPost();

    @POST("mahasiswa")
    Call<ResponseBody> createPost(@Body Post post);

    @PUT("mahasiswa")
    Call<Post> updatePost(@Body Post post);





}
