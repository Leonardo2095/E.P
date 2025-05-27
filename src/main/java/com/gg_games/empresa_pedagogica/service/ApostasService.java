package com.gg_games.empresa_pedagogica.service;


import com.gg_games.empresa_pedagogica.dto.ApostasCreateDTO;
import com.gg_games.empresa_pedagogica.dto.ApostasDTO;
import com.gg_games.empresa_pedagogica.model.UserModel;
import com.gg_games.empresa_pedagogica.model.ApostasModel;
import com.gg_games.empresa_pedagogica.model.CompetitorModel;
import com.gg_games.empresa_pedagogica.model.UserRoles;
import com.gg_games.empresa_pedagogica.repository.UserRepository;
import com.gg_games.empresa_pedagogica.repository.ApostasRepository;
import com.gg_games.empresa_pedagogica.repository.CompetitorRepository;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApostasService {
    ApostasRepository apostasRepository;
    CompetitorRepository competitorRepository;
    UserRepository userRepository;

    public ApostasService(ApostasRepository apostasRepository, CompetitorRepository competitorRepository, UserRepository userRepository){
        this.apostasRepository = apostasRepository;
        this.competitorRepository = competitorRepository;
        this.userRepository = userRepository;
    }


    public ApostasDTO save(ApostasCreateDTO dto){
        ApostasModel apostas = new ApostasModel();

        CompetitorModel c= competitorRepository.findById(dto.getCompetitorID())
                        .orElseThrow(() -> new RuntimeException("Competidor não encontrado"));

        UserModel a= userRepository.findById(dto.getUserID())
                .orElseThrow(() -> new RuntimeException("Usuario não Encontrado"));

        apostas.setUser(a);
        apostas.setCompetitor(c);
        apostas.setGambleState(apostas.getGambleState());
        apostas.setGambleValue(apostas.getGambleValue());
        apostasRepository.save(apostas);

        return  new ApostasDTO(apostas);
    }

    public List<ApostasDTO> listar (Long userID){
        List<ApostasModel> apostas = apostasRepository.findAllByUser_UserID(userID);
        return apostas.stream()
                .map(ApostasDTO::new)
                .collect(Collectors.toList());
    }

    public List<ApostasDTO> listarTodasApostas()  {

        List<ApostasModel> apostas = apostasRepository.findAll();

        return apostas.stream()
                .map(ApostasDTO::new)
                .collect(Collectors.toList());
    }

}
