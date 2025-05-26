package com.gg_games.empresa_pedagogica.controller;

import com.gg_games.empresa_pedagogica.dto.AuthDTO;
import com.gg_games.empresa_pedagogica.dto.AuthResDTO;
import com.gg_games.empresa_pedagogica.dto.RegisterReqDTO;
import com.gg_games.empresa_pedagogica.infra.security.TokenService;
import com.gg_games.empresa_pedagogica.model.UserModel;
import com.gg_games.empresa_pedagogica.model.UserRoles;
import com.gg_games.empresa_pedagogica.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    private AuthenticationManager authenticationManager;

    private UserRepository repository;

    private TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, UserRepository repository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.tokenService = tokenService;
    }



    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO dto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getUserPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        return ResponseEntity.ok(new AuthResDTO(token));
    }

    @PostMapping("/registro")
    public  ResponseEntity registro(@RequestBody @Valid RegisterReqDTO dto) {
        if (this.repository.findByUserName(dto.getUserName()) != null) {
            return ResponseEntity.badRequest().build();
        }

        dto.setRole(UserRoles.USER);
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getUserPassword());
        UserModel user = new UserModel(dto.getUserName(), dto.getUserClassroom(), encryptedPassword, dto.getUserPix(), dto.getRole());

        repository.save(user);
        return  ResponseEntity.ok().build();
}}
