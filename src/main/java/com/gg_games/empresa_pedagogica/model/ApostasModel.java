package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_apostas")
public class ApostasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gambleID;

    @Column(nullable = false)
    private float gambleValue;
    @Column(nullable = false)
    //Diz se a aposta foi paga ou não
    private String gambleState = "Nao foi paga";

    @ManyToOne
    @JoinColumn(name = "gamblerID")
    private ApostadorModel gambler;

    @ManyToOne
    @JoinColumn(name = "competitorID")
    private CompetitorModel competitor;

    @ManyToOne
    @JoinColumn(name = "admimID")
    private AdmimModel admim;


    private LocalDateTime dateTime;


    public ApostasModel() {
    }

    public ApostasModel(float gambleValue, ApostadorModel gambler, CompetitorModel competitor, AdmimModel admim) {
        this.gambleValue = gambleValue;
        this.gambler = gambler;
        this.competitor = competitor;
        this.admim = admim;
    }

    public ApostadorModel getGambler() {
        return gambler;
    }

    public void setGambler(ApostadorModel gambler) {
        this.gambler = gambler;
    }

    public CompetitorModel getCompetitor() {
        return competitor;
    }

    public void setCompetitor(CompetitorModel competitor) {
        this.competitor = competitor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    public AdmimModel getAdmim() {
        return admim;
    }

    public void setAdmim(AdmimModel admim) {
        this.admim = admim;
    }
}
