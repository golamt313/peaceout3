package com.services.api.v1.models;
public class Token {
    private String jwtToken;

    public Token(String token){
        this.jwtToken = token;
    }
    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
