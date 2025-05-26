package com.gg_games.empresa_pedagogica.dto;

public class AuthResDTO {
    private  String token;

    public AuthResDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
