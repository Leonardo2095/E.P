package com.gg_games.empresa_pedagogica.controller;

import com.gg_games.empresa_pedagogica.model.ApostadorModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_apostas")
public class ApostasController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private float gambleValue;
    @Column(nullable = false)
    //Diz se a aposta foi paga ou não
    private String gambleState = "Nao foi paga";

    @ManyToOne
    @JoinColumn(name = "gamblerID")
    private ApostadorModel gambler;

    public ApostasController() {
    }

    public ApostasController(float gambleValue) {
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
