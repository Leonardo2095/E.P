package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;

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
    private String gamblerPass;
    @Column(nullable = false)
    private String gamblerPix;

}
