package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name= "tb_apostador")

public class ApostadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gamblerID;

    @Column(nullable = false)
    private String gamblerName;
    @Column(nullable = false)
    private String gamblerClassroom;
    @Column(nullable = false)
    private String gamblerPassword;
    @Column(nullable = false)
    private String gamblerPix;

    @OneToMany(mappedBy = "gambler")
    private List<ApostasModel> gambles;

    @ManyToOne
    @JoinColumn(name= "admimID")
    private AdmimModel admim;


    public ApostadorModel(String gamblerName, String gamblerClassroom, String gamblerPassword, String gamblerPix, List<ApostasModel> gambles, AdmimModel admim) {
        this.gamblerName = gamblerName;
        this.gamblerClassroom = gamblerClassroom;
        this.gamblerPassword = gamblerPassword;
        this.gamblerPix = gamblerPix;
        this.gambles = gambles;
        this.admim = admim;
    }

    public AdmimModel getAdmim() {
        return admim;
    }

    public void setAdmim(AdmimModel admim) {
        this.admim = admim;
    }

    public ApostadorModel() {
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

    public String getGamblerPassword() {
        return gamblerPassword;
    }

    public void setGamblerPassword(String gamblerPassword) {
        this.gamblerPassword = gamblerPassword;
    }

    public String getGamblerPix() {
        return gamblerPix;
    }

    public void setGamblerPix(String gamblerPix) {
        this.gamblerPix = gamblerPix;
    }

    public List<ApostasModel> getGambles() {
        return gambles;
    }

    public void setGambles(List<ApostasModel> gambles) {
        this.gambles = gambles;
    }

    public Long getGamblerID() {
        return gamblerID;
    }

    public void setGamblerID(Long gamblerID) {
        this.gamblerID = gamblerID;
    }
}
