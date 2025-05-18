package com.gg_games.empresa_pedagogica.model;

import com.gg_games.empresa_pedagogica.dto.ApostadorCreateDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name= "tb_apostador")

public class ApostadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gamblerID;

    @Column(nullable = false)
    private String gamblerName;
    @Column(nullable = false, unique = true)
    private String gamblerClassroom;
    @Column(nullable = false)
    private String gamblerPassword;
    @Column(nullable = false)
    private String gamblerPix;

    @OneToMany(mappedBy = "gambler")
    private List<ApostasModel> gambles;

    public ApostadorModel(ApostadorCreateDTO gambler){
        BeanUtils.copyProperties(gambler, this);
    }

    public ApostadorModel(String gamblerName, String gamblerClassroom, String gamblerPassword, String gamblerPix, List<ApostasModel> gambles) {
        this.gamblerName = gamblerName;
        this.gamblerClassroom = gamblerClassroom;
        this.gamblerPassword = gamblerPassword;
        this.gamblerPix = gamblerPix;
        this.gambles = gambles;
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
