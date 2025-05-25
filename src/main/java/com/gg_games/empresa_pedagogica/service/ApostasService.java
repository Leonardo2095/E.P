package com.gg_games.empresa_pedagogica.service;


import com.gg_games.empresa_pedagogica.dto.ApostasCreateDTO;
import com.gg_games.empresa_pedagogica.dto.ApostasDTO;
import com.gg_games.empresa_pedagogica.model.ApostadorModel;
import com.gg_games.empresa_pedagogica.model.ApostasModel;
import com.gg_games.empresa_pedagogica.model.CompetitorModel;
import com.gg_games.empresa_pedagogica.repository.ApostadorRepository;
import com.gg_games.empresa_pedagogica.repository.ApostasRepository;
import com.gg_games.empresa_pedagogica.repository.CompetitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApostasService {
    ApostasRepository apostasRepository;
    CompetitorRepository competitorRepository;
    ApostadorRepository apostadorRepository;

    public ApostasService(ApostasRepository apostasRepository, CompetitorRepository competitorRepository, ApostadorRepository apostadorRepository){
        this.apostasRepository = apostasRepository;
        this.competitorRepository = competitorRepository;
        this.apostadorRepository = apostadorRepository;
    }


    public ApostasDTO save(ApostasCreateDTO dto){
        ApostasModel apostas = new ApostasModel();

        CompetitorModel c= competitorRepository.findById(dto.getCompetitorID())
                        .orElseThrow(() -> new RuntimeException("Competidor não encontrado"));

        ApostadorModel a= apostadorRepository.findById(dto.getGamblerID())
                .orElseThrow(() -> new RuntimeException("Usuario não Encontrado"));

        apostas.setGambler(a);
        apostas.setCompetitor(c);
        apostas.setGambleState(apostas.getGambleState());
        apostas.setGambleValue(apostas.getGambleValue());
        apostasRepository.save(apostas);

        return  new ApostasDTO(apostas);
    }

    public List<ApostasDTO> listar (Long gamblerID){
        List<ApostasModel> apostas = apostasRepository.findAllByGambler_GamblerID(gamblerID);
        return apostas.stream()
                .map(ApostasDTO::new)
                .collect(Collectors.toList());
    }


}
