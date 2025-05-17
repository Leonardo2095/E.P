package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_apostas")
public class ApostasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gamblerID;

    @Column(nullable = false)
    private String gamblerName;
    @Column(nullable = false, unique = true)
    private String gamblerClassroom;
    @Column(nullable = false)
    private String gamblerPass;
    @Column(nullable = false)
    private String gamblerPix;
    @Column(nullable = false)
    private float gambleValue;
    @Column(nullable = false)
    //Diz se a aposta foi paga ou não
    private String gambleState;
    //Diz se a partida esta sendo jogada, se tiver nao poderao haver novas apostas
    private boolean isPlaying= false;

    public ApostasModel() {
    }

    public ApostasModel(String gamblerName, String gamblerClassroom, String gamblerPass, String gamblerPix, float gambleValue) {
        this.gamblerName = gamblerName;
        this.gamblerClassroom = gamblerClassroom;
        this.gamblerPass = gamblerPass;
        this.gamblerPix = gamblerPix;
        this.gambleValue = gambleValue;
        this.isPlaying = false;
        this.gambleState = "Não pago";
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

    public String getGamblerPass() {
        return gamblerPass;
    }

    public void setGamblerPass(String gamblerPass) {
        this.gamblerPass = gamblerPass;
    }

    public String getGamblerPix() {
        return gamblerPix;
    }

    public void setGamblerPix(String gamblerPix) {
        this.gamblerPix = gamblerPix;
    }

    public Long getGamblerID() {
        return gamblerID;
    }

    public void setGamblerID(Long gamblerID) {
        this.gamblerID = gamblerID;
    }
}
