package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy = "tournament")
    private List<CompetitorModel> competitor;

    @ManyToOne
    @JoinColumn(name = "userID")
    private UserModel user;
    public TorneioModel(){
    }


    public TorneioModel(String data, String rules, List<CompetitorModel> competitor, UserModel user) {
        this.data = data;
        this.rules = rules;
        this.competitor = competitor;
        this.user= user;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<CompetitorModel> getCompetitor() {
        return competitor;
    }

    public void setCompetitor(List<CompetitorModel> competitor) {
        this.competitor = competitor;
    }

    public Long getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(Long tournamentID) {
        this.tournamentID = tournamentID;
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
