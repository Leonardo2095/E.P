package com.gg_games.empresa_pedagogica.service;

import com.gg_games.empresa_pedagogica.dto.ApostadorCreateDTO;
import com.gg_games.empresa_pedagogica.dto.ApostadorDTO;
import com.gg_games.empresa_pedagogica.model.ApostadorModel;
import com.gg_games.empresa_pedagogica.repository.ApostadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ApostadorService {
    private ApostadorRepository apostadorRepository;

    public ApostadorService(ApostadorRepository apostadorRepository) {
        this.apostadorRepository = apostadorRepository;
    }

    public ApostadorModel save (ApostadorCreateDTO createDTO ){
        ApostadorModel apostador = new ApostadorModel();
        apostador.setGamblerName(createDTO.getGamblerName());
        apostador.setGamblerClassroom(createDTO.getGamblerClassroom());
        apostador.setGamblerPassword(createDTO.getGamblerPassword());
        apostador.setGamblerPix(createDTO.getGamblerPix());

        return apostadorRepository.save(apostador);
    }

    public void update(Long id, ApostadorCreateDTO dto){
        ApostadorModel apostador = apostadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Apostador não encontrado"));

        if(dto.getGamblerClassroom() != null){
            dto.setGamblerClassroom(dto.getGamblerClassroom());
        }

        if (dto.getGamblerName() != null){
            dto.setGamblerName(dto.getGamblerName());
        }

        if (dto.getGamblerPassword() != null){
            dto.setGamblerPassword(dto.getGamblerPassword());
        }

        if (dto.getGamblerPix() != null){
            dto.setGamblerPix(dto.getGamblerPix());
        }

        apostadorRepository.save(apostador);
    }

}
