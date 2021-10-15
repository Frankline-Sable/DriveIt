package com.example.driveit.network;


import com.example.driveit.pojo.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("login")
    Call<LoginResponse> createUser(@Body LoginResponse login);


}
