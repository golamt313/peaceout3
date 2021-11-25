package com.services.api.v1.interf.retro;

import com.services.api.v1.models.AuthRequest;
import com.services.api.v1.models.Token;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AuthAPI {
    @POST("api/auth/login")
    Call<AuthRequest> login(@Body AuthRequest userRequest);
    @POST("api/auth/validate")
    Call<AuthRequest> validate(@Body Token token);
    @GET("")
    Call<AuthRequest> getsomething(@Header("token") String token);
}
