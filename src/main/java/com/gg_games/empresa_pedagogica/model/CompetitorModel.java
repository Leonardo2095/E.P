package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;

@Entity
@Table(name= "tb_competitor")
public class CompetitorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long competitorId;

    @Column(nullable = false)
    private String competitorName;
    @Column(nullable = false, unique = true)
    private String competitorNumber;
    @Column(nullable = false)
    private String competitorClassroom;
    @Column(nullable = false)
    private String paymentStatus= "Devendo";

    public CompetitorModel() {

    }

    public CompetitorModel(String competitorName, String competitorNumber, String competitorClassroom) {
        this.competitorName = competitorName;
        this.competitorNumber = competitorNumber;
        this.competitorClassroom = competitorClassroom;
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public Long getCompetitorId() {
        return competitorId;
    }

    public void setCompetitorId(Long competitorId) {
        this.competitorId = competitorId;
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
