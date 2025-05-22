package com.gg_games.empresa_pedagogica.dto;

public class ApostadorDTO {
    private String gamblerName;
    private String gamblerClassroom;
    private String gamblerPix;

    public ApostadorDTO(String gamblerPix, String gamblerName, String gamblerClassroom) {
    }

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

    public String getGamblerPix() {
        return gamblerPix;
    }

    public void setGamblerPix(String gamblerPix) {
        this.gamblerPix = gamblerPix;
    }
}
