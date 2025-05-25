package com.gg_games.empresa_pedagogica.dto;

import com.gg_games.empresa_pedagogica.model.ApostadorModel;

public class ApostadorDTO {
    private String gamblerName;
    private String gamblerClassroom;
    private String gamblerPix;

    public ApostadorDTO(ApostadorModel model) {
        this.gamblerName = model.getGamblerName();
        this.gamblerClassroom = model.getGamblerClassroom();
        this.gamblerPix = model.getGamblerPix();
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
