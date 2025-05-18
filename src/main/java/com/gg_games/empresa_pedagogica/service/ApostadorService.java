package com.gg_games.empresa_pedagogica.service;

import com.gg_games.empresa_pedagogica.dto.ApostadorCreateDTO;
import com.gg_games.empresa_pedagogica.dto.ApostadorDTO;
import com.gg_games.empresa_pedagogica.model.ApostadorModel;
import com.gg_games.empresa_pedagogica.model.ApostasModel;
import com.gg_games.empresa_pedagogica.repository.ApostadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApostadorService {
    private ApostadorRepository apostadorRepository;

    public ApostadorService(ApostadorRepository apostadorRepository) {
        this.apostadorRepository = apostadorRepository;
    }

    public ApostadorModel create (ApostadorCreateDTO createDTO ){
        ApostadorModel apostador = new ApostadorModel();
        apostador.setGamblerName(createDTO.getGamblerName());
        apostador.setGamblerClassroom(createDTO.getGamblerClassroom());
        apostador.setGamblerPassword(createDTO.getGamblerPassword());
        apostador.setGamblerPix(createDTO.getGamblerPix());

        return apostadorRepository.save(apostador);

    }


}
