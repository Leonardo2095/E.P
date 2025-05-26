package com.gg_games.empresa_pedagogica.service;

import com.gg_games.empresa_pedagogica.dto.UserDTO;
import com.gg_games.empresa_pedagogica.model.UserModel;
import com.gg_games.empresa_pedagogica.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDetails encontrar (String userName){

        return userRepository.findByUserName(userName);
    }

    public UserModel findById (Long userID){
        return  userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Usuario Inexistente"));
    }

    public UserModel update(Long id, UserDTO dto){
        UserModel apostador = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));

        if(dto.getUserClassroom() != null){
            dto.setUserClassroom(dto.getUserClassroom());
        }

        if (dto.getUserName() != null){
            dto.setUserName(dto.getUserName());
        }

        if (dto.getUserPix() != null){
            dto.setUserPix(dto.getUserPix());
        }

        return userRepository.save(apostador);
    }

}
