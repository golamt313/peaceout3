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
    public boolean validate(Token token) throws IOException {
        int code = this.authAPI.validate(token).execute().code();
        return code == 200 ? true :false ;
    }

    @Override
    public Object getsomething(Token token) throws IOException {
        return this.authAPI.getsomething(token.getJwtToken()).execute().body();
    }
}
