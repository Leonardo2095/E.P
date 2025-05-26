package com.gg_games.empresa_pedagogica.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

@Entity
@Table(name= "tb_user")

public class UserModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String userClassroom;
    @Column(nullable = false)
    private String userPassword;
    @Column(nullable = false)
    private String userPix;
    private UserRoles role;

    @OneToMany(mappedBy = "user")
    private List<ApostasModel> gambles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRoles.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }
    }
    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserModel() {
    }

    public UserModel(String userName, Long userID, String userClassroom, String userPassword, String userPix, List<ApostasModel> gambles, UserRoles role) {
        this.userName = userName;
        this.userID = userID;
        this.userClassroom = userClassroom;
        this.userPassword = userPassword;
        this.userPix = userPix;
        this.gambles = gambles;
        this.role = role;
    }

    public UserModel(String userName, String userClassroom, String userPassword, String userPix, UserRoles role) {
        this.userName = userName;
        this.userClassroom = userClassroom;
        this.userPassword = userPassword;
        this.userPix = userPix;
        this.role = role;
    }

    public String getUserPix() {
        return userPix;
    }

    public void setUserPix(String userPix) {
        this.userPix = userPix;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public List<ApostasModel> getGambles() {
        return gambles;
    }

    public void setGambles(List<ApostasModel> gambles) {
        this.gambles = gambles;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserClassroom() {
        return userClassroom;
    }

    public void setUserClassroom(String userClassroom) {
        this.userClassroom = userClassroom;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
