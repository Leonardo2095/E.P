package com.gg_games.empresa_pedagogica.dto;

import com.gg_games.empresa_pedagogica.model.UserRoles;

public class RegisterReqDTO {
    private String userName;
    private String userClassroom;
    private String userPassword;
    private String userPix;
    private UserRoles role;

    public RegisterReqDTO(String userName, String userClassroom, String userPassword, String userPix, UserRoles role) {
        this.userName = userName;
        this.userClassroom = userClassroom;
        this.userPassword = userPassword;
        this.userPix = userPix;
        this.role = role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserClassroom() {
        return userClassroom;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserPix() {
        return userPix;
    }

    public UserRoles getRole() {
        return role;
    }
}
