package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_torneio")
public class TorneioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournamentID;

    @Column(nullable = false)
    private boolean isRunning =false;
    private String data;
    private String rules;


    private CompetitorModel competitor;

    public TorneioModel(){
    }
    public TorneioModel(CompetitorModel competitor ,String rules, String data) {
        this.competitor = competitor;
        this.rules = rules;
        this.data= data;
    }

    public CompetitorModel getCompetitor() {
        return competitor;
    }

    public void setCompetitor(CompetitorModel competitor) {
        this.competitor = competitor;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
