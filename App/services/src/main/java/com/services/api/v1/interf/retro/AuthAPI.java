package com.services.api.v1.interf.retro;

import com.services.api.v1.models.AuthRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AuthAPI {
    @POST("api/auth/login")
    Call<AuthRequest> login(@Body AuthRequest userRequest);
    @POST("api/auth/validate")
    Call<AuthRequest> validate(@Header("Token") AuthRequest userRequest);
}
