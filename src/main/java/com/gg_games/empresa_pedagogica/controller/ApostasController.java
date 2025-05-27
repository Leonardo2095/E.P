package com.gg_games.empresa_pedagogica.controller;

import com.gg_games.empresa_pedagogica.dto.ApostasCreateDTO;
import com.gg_games.empresa_pedagogica.dto.ApostasDTO;
import com.gg_games.empresa_pedagogica.model.ApostasModel;
import com.gg_games.empresa_pedagogica.model.UserModel;
import com.gg_games.empresa_pedagogica.repository.UserRepository;
import com.gg_games.empresa_pedagogica.service.ApostasService;
import com.gg_games.empresa_pedagogica.service.AuthService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/apostas")
public class ApostasController {
    ApostasService apostasService;
    UserRepository userRepository;
    AuthService authService;

    public ApostasController(ApostasService apostasService, UserRepository userRepository, AuthService authService) {
        this.apostasService = apostasService;
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @PostMapping("/apostar")
    ResponseEntity <ApostasDTO> criar (@RequestBody ApostasCreateDTO dto){
        ApostasDTO aposta = apostasService.save(dto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(aposta);
    }

    @GetMapping("/admin/historico/{userID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ApostasDTO>> findAllByUser_UserID(@PathVariable Long userID) {
        List<ApostasDTO> apostas = apostasService.listar(userID);
        return ResponseEntity.ok(apostas);
    }

    @GetMapping("/historico/{userID}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ApostasDTO>> findAllByUser_UserID_User(@PathVariable Long userID) throws AccessDeniedException {


        List<ApostasDTO> apostas = apostasService.listar(userID);
        return ResponseEntity.ok(apostas);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/seeall/")
    public ResponseEntity<List<ApostasDTO>> listarTodasApostas() throws AccessDeniedException {


        List<ApostasDTO> apostas = apostasService.listarTodasApostas();

        return ResponseEntity.ok(apostas);
}}
