package com.gg_games.empresa_pedagogica.dto;

import com.gg_games.empresa_pedagogica.model.ApostadorModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.BeanUtils;

public class ApostadorCreateDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String gamblerName;

    @NotBlank(message = "A turma é obrigatória")
    private String gamblerClassroom;

    @NotBlank(message = "Senha obrigatória")
    @Size(min= 6, message = "A senha deve ter no minimo 6 caracteres")
    private String gamblerPassword;

    @NotBlank(message = "A chave Pix não pode estar em branco")
    private String gamblerPix;

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
}
