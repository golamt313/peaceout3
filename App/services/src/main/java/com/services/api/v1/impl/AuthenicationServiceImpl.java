package com.services.api.v1.impl;

import com.services.api.v1.interf.AuthenicationServiceInter;
import com.services.api.v1.interf.retro.AuthAPI;
import com.services.api.v1.models.AuthRequest;
import com.services.api.v1.models.Token;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthenicationServiceImpl implements AuthenicationServiceInter {
    private Retrofit retrofit;
    private AuthAPI authAPI;
    private String baseUrl;

    public AuthenicationServiceImpl(String url){
        this.baseUrl = url;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.authAPI = retrofit.create(AuthAPI.class);
    }

    @Override
    public Token login(AuthRequest userRequest) throws IOException {
        return new Token(this.authAPI.login(userRequest).execute().body().getToken()) ;
    }

    @Override
    public boolean validate(String token) throws IOException {
        AuthRequest userRequest = new AuthRequest();
        userRequest.setToken(token);
        return this.authAPI.validate(userRequest).execute().code() == 200 ? true :false ;
    }
}
