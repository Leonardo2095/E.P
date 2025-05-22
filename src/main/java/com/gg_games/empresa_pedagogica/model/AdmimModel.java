package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_adm")
public class AdmimModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer admimID;

    private String nome;
    private String senha;

    @OneToMany(mappedBy = "admim")
    private List<ApostadorModel> gamblers;

    @OneToMany(mappedBy = "admim")
    private List<ApostasModel> gambles;

    @OneToMany(mappedBy = "admim")
    private List<CompetitorModel> competitors ;

    @OneToMany(mappedBy = "admim")
    private List<PostModel> posts;

    @OneToMany(mappedBy = "admim")
    private List<TorneioModel> tournaments;

    public AdmimModel() {
    }

    public AdmimModel(String nome, String senha, List<ApostadorModel> gamblers, List<CompetitorModel> competitors, List<ApostasModel> gambles, List<PostModel> posts, List<TorneioModel> tournaments) {
        this.nome = nome;
        this.senha = senha;
        this.gamblers = gamblers;
        this.competitors = competitors;
        this.gambles = gambles;
        this.posts = posts;
        this.tournaments = tournaments;
    }

    public Integer getAdmimID() {
        return admimID;
    }

    public void setAdmimID(Integer admimID) {
        this.admimID = admimID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<ApostasModel> getGambles() {
        return gambles;
    }

    public void setGambles(List<ApostasModel> gambles) {
        this.gambles = gambles;
    }

    public List<ApostadorModel> getGamblers() {
        return gamblers;
    }

    public void setGamblers(List<ApostadorModel> gamblers) {
        this.gamblers = gamblers;
    }

    public List<CompetitorModel> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<CompetitorModel> competitors) {
        this.competitors = competitors;
    }

    public List<PostModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostModel> posts) {
        this.posts = posts;
    }

    public List<TorneioModel> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<TorneioModel> tournaments) {
        this.tournaments = tournaments;
    }
}
