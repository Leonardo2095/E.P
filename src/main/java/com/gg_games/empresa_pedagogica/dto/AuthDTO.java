package com.gg_games.empresa_pedagogica.dto;

public class AuthDTO {
    private String userPassword;
    private String userName;

    public AuthDTO(String userPassword, String userName) {
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
