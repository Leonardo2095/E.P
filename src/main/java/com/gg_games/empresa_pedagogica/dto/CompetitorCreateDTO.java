package com.gg_games.empresa_pedagogica.dto;

public class CompetitorCreateDTO {
    private String competitorName;
    private String competitorNumber;
    private String competitorClassroom;
    private String paymentStatus;


    public String getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public String getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(String competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public String getCompetitorClassroom() {
        return competitorClassroom;
    }

    public void setCompetitorClassroom(String competitorClassroom) {
        this.competitorClassroom = competitorClassroom;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
