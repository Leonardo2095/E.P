package com.gg_games.empresa_pedagogica.dto;

import com.gg_games.empresa_pedagogica.model.UserModel;

public class UserDTO {
    private String userName;
    private String userClassroom;
    private String userPix;


    public UserDTO(UserModel model) {
        this.userName = model.getUserName();
        this.userClassroom = model.getUserClassroom();
        this.userPix = model.getUserPix();
    }

    public void setUserClassroom(String userClassroom) {
        this.userClassroom = userClassroom;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPix(String userPix) {
        this.userPix = userPix;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserClassroom() {
        return userClassroom;
    }

    public String getUserPix() {
        return userPix;
    }
}
