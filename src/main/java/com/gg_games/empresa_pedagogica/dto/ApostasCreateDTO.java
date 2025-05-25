package com.gg_games.empresa_pedagogica.dto;

public class ApostasCreateDTO {

    private Long competitorID;
    private Long gamblerID;
    private Long gambleID;
    private float gambleValue;
    private String gambleState;
    private String competitorName;

    public Long getCompetitorID() {
        return competitorID;
    }

    public Long getGamblerID() {
        return gamblerID;
    }

    public void setGamblerID(Long gamblerID) {
        this.gamblerID = gamblerID;
    }

    public void setCompetitorID(Long competitorID) {
        this.competitorID = competitorID;
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


    public Long getGambleID() {
        return gambleID;
    }

    public void setGambleID(Long gambleID) {
        this.gambleID = gambleID;
    }
}


