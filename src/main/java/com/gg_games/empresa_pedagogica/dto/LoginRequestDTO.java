package com.gg_games.empresa_pedagogica.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {
    @NotBlank
    String gamblerName;
    @NotBlank
    String gamblerPassword;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String gamblerName, String gamblerPassword) {
        this.gamblerName = gamblerName;
        this.gamblerPassword = gamblerPassword;
    }
}
