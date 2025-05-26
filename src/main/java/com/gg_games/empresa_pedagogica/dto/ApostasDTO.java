package com.gg_games.empresa_pedagogica.dto;

import com.gg_games.empresa_pedagogica.model.ApostasModel;

public class ApostasDTO {
    private float gambleValue;
    private String gambleState;
    private String competitorName;

    public ApostasDTO(ApostasModel model){
        this.gambleState = model.getGambleState();
        this.competitorName= model.getCompetitor().getCompetitorName();
        this.gambleValue = model.getGambleValue();
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public float getGambleValue() {
        return gambleValue;
    }

    public void setGambleValue(float gambleValue) {
        this.gambleValue = gambleValue;
    }

    public String getGambleState() {
        return gambleState;
    }

    public void setGambleState(String gambleState) {
        this.gambleState = gambleState;
    }

}
