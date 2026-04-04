package com.sgico.tp5.dto.auth;

public class AuthResponse {

    private String token;
    private String tokenType;

    public AuthResponse(String token, String tokenType) {
        this.token = token;
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }
}

