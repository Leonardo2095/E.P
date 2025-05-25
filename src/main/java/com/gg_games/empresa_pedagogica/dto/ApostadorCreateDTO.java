package com.gg_games.empresa_pedagogica.dto;

import jakarta.validation.constraints.Size;

public class ApostadorCreateDTO {
    private String gamblerName;
    private String gamblerClassroom;

    private String gamblerPassword;

    private String gamblerPix;



    public String getGamblerName() {
        return gamblerName;
    }

    public void setGamblerName(String gamblerName) {
        this.gamblerName = gamblerName;
    }

    public String getGamblerClassroom() {
        return gamblerClassroom;
    }

    public void setGamblerClassroom(String gamblerClassroom) {
        this.gamblerClassroom = gamblerClassroom;
    }

    public String getGamblerPassword() {
        return gamblerPassword;
    }

    public void setGamblerPassword(String gamblerPassword) {
        this.gamblerPassword = gamblerPassword;
    }

    public String getGamblerPix() {
        return gamblerPix;
    }

    public void setGamblerPix(String gamblerPix) {
        this.gamblerPix = gamblerPix;
    }
}
