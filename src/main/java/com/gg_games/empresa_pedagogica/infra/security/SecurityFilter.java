package com.gg_games.empresa_pedagogica.infra.security;

import com.gg_games.empresa_pedagogica.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    TokenService tokenService;
    UserRepository userRepository;


    public SecurityFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recovertoken(request);
        if(token != null){
            var userName = tokenService.validateToken(token);
            UserDetails user= userRepository.findByUserName(userName);

            var authentication= new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request,response);
    }

    private String recovertoken(HttpServletRequest request) {
        var authHeader=request.getHeader("Authorization");
        if(authHeader ==null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
