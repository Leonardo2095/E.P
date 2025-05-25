package com.gg_games.empresa_pedagogica.controller;

import com.gg_games.empresa_pedagogica.dto.ApostasCreateDTO;
import com.gg_games.empresa_pedagogica.dto.ApostasDTO;
import com.gg_games.empresa_pedagogica.model.ApostadorModel;
import com.gg_games.empresa_pedagogica.service.ApostasService;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apostas")
public class ApostasController {
    ApostasService apostasService;

    public ApostasController (ApostasService apostasService){
        this.apostasService = apostasService;
    }

    @PostMapping("/apostar")
    ResponseEntity <ApostasDTO> criar (@RequestBody ApostasCreateDTO dto){
        ApostasDTO aposta = apostasService.save(dto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(aposta);
    }

    @GetMapping("/historico{gamblerID}")
    ResponseEntity <List<ApostasDTO>> findAllByGamblerID (@PathVariable Long gamblerID){
        List<ApostasDTO> a = apostasService.listar(gamblerID);

        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }
}
