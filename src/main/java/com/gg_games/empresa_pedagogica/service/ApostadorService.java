package com.gg_games.empresa_pedagogica.service;

import com.gg_games.empresa_pedagogica.dto.ApostadorCreateDTO;
import com.gg_games.empresa_pedagogica.dto.ApostadorDTO;
import com.gg_games.empresa_pedagogica.model.ApostadorModel;
import com.gg_games.empresa_pedagogica.repository.ApostadorRepository;
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

    public Optional<ApostadorDTO> update (Long id, ApostadorCreateDTO updateDTO){
        return apostadorRepository.findById(id)
                .map(apostador -> {
                    apostador.setGamblerName(updateDTO.getGamblerName());
                    apostador.setGamblerClassroom(updateDTO.getGamblerClassroom());
                    apostador.setGamblerPassword(updateDTO.getGamblerPassword());
                    apostador.setGamblerPix(updateDTO.getGamblerPix());
                    ApostadorModel apostadorUpdated = apostadorRepository.save(apostador);

                    return new ApostadorDTO(
                            apostadorUpdated.getGamblerPix(),
                            apostadorUpdated.getGamblerName(),
                            apostadorUpdated.getGamblerClassroom()
                    );
                });
    }

}
