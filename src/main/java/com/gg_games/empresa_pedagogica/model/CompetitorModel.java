package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Entity
@Table(name= "tb_competitor")
public class CompetitorModel{
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

    @ManyToOne
    @JoinColumn(name = "tournamentID")
    private TorneioModel tournament;

    @OneToMany(mappedBy = "competitor")
    private List<ApostasModel> gambles;

    @ManyToOne
    @JoinColumn(name = "admimID")
    private AdmimModel admim;

    public CompetitorModel() {

    }

    public CompetitorModel(String competitorName, String competitorNumber, String competitorClassroom, TorneioModel tournament, List<ApostasModel> gambles, AdmimModel admim) {
        this.competitorName = competitorName;
        this.competitorNumber = competitorNumber;
        this.competitorClassroom = competitorClassroom;
        this.tournament = tournament;
        this.gambles = gambles;
        this.admim = admim;
        this.paymentStatus = "Devendo";
    }

    public AdmimModel getAdmim() {
        return admim;
    }

    public void setAdmim(AdmimModel admim) {
        this.admim = admim;
    }

    public TorneioModel getTournament() {
        return tournament;
    }

    public void setTournament(TorneioModel tournament) {
        this.tournament = tournament;
    }

    public List<ApostasModel> getGambles() {
        return gambles;
    }

    public void setGambles(List<ApostasModel> gambles) {
        this.gambles = gambles;
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
