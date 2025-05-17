package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_apostas")
public class ApostasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private float gambleValue;
    @Column(nullable = false)
    //Diz se a aposta foi paga ou não
    private String gambleState = "Nao foi paga";

    private ApostadorModel gambler;

    public ApostasModel() {
    }

    public ApostasModel(float gambleValue) {
        this.gambleValue = gambleValue;
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
