package com.gg_games.empresa_pedagogica.controller;

import com.gg_games.empresa_pedagogica.dto.ApostasCreateDTO;
import com.gg_games.empresa_pedagogica.dto.ApostasDTO;
import com.gg_games.empresa_pedagogica.model.ApostasModel;
import com.gg_games.empresa_pedagogica.model.UserModel;
import com.gg_games.empresa_pedagogica.repository.UserRepository;
import com.gg_games.empresa_pedagogica.service.ApostasService;
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

    public ApostasController(ApostasService apostasService, UserRepository userRepository) {
        this.apostasService = apostasService;
        this.userRepository = userRepository;
    }

    private UserModel getUsuarioAutenticado() throws AccessDeniedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AccessDeniedException("Usuário não autenticado");
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserModel user) {
            return user;
        }

        throw new AccessDeniedException("Usuário autenticado inválido");
    }

    @PostMapping("/apostar")
    ResponseEntity <ApostasDTO> criar (@RequestBody ApostasCreateDTO dto){
        ApostasDTO aposta = apostasService.save(dto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(aposta);
    }

    @GetMapping("/historico/{userID}")
    @PreAuthorize("hasRole('ADMIN') or #userID == principal.userID")
    public ResponseEntity<List<ApostasDTO>> findAllByUser_UserID(@PathVariable Long userID) {
        List<ApostasDTO> apostas = apostasService.listar(userID);
        return ResponseEntity.ok(apostas);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/seeall/")
    public ResponseEntity<List<ApostasDTO>> listarTodasApostas(Principal principal) throws AccessDeniedException {

        UserModel user = getUsuarioAutenticado();
        List<ApostasDTO> apostasDTO = apostasService.listarTodasApostas(user)
                .stream()
                .map(ApostasDTO::new) // Construtor que converte de ApostasModel para ApostasDTO
                .toList();

        return ResponseEntity.ok(apostasDTO);
}}
