package com.gg_games.empresa_pedagogica.model;

public enum UserRoles {

    ADMIN("admin"),
    USER("user");

    private String roles;
    private UserRoles(String roles){
        this.roles =roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getRoles() {
        return roles;
    }

}
