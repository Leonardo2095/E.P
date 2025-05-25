package com.gg_games.empresa_pedagogica.controller;

import com.gg_games.empresa_pedagogica.dto.ApostadorCreateDTO;
import com.gg_games.empresa_pedagogica.dto.ApostadorDTO;
import com.gg_games.empresa_pedagogica.model.ApostadorModel;
import com.gg_games.empresa_pedagogica.service.ApostadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/apostador")
public class ApostadorController {
    ApostadorService apostadorService;

    public ApostadorController(ApostadorService apostadorService) {
        this.apostadorService = apostadorService;

    }

    @PostMapping("/registro")
    public ResponseEntity <Void> create(@RequestBody ApostadorCreateDTO dto) {
        ApostadorDTO gambler = apostadorService.save(dto);

        return ResponseEntity.noContent().build();

    }


    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Void> updateApostador(
            @PathVariable Long id,
            @RequestBody ApostadorCreateDTO dto)
        {apostadorService.update(id, dto);
        return ResponseEntity.noContent().build();
        }
}
