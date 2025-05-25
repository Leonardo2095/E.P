package com.gg_games.empresa_pedagogica.service;

import com.gg_games.empresa_pedagogica.dto.ApostadorDTO;
import com.gg_games.empresa_pedagogica.dto.ApostasDTO;
import com.gg_games.empresa_pedagogica.dto.CompetitorCreateDTO;
import com.gg_games.empresa_pedagogica.dto.CompetitorDTO;
import com.gg_games.empresa_pedagogica.model.ApostasModel;
import com.gg_games.empresa_pedagogica.model.CompetitorModel;
import com.gg_games.empresa_pedagogica.repository.CompetitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitorService {
    CompetitorRepository competitorRepository;

    public CompetitorService(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    public CompetitorDTO save (CompetitorCreateDTO dto){
        CompetitorModel c = new CompetitorModel();

        c.setCompetitorClassroom(dto.getCompetitorClassroom());
        c.setCompetitorName(dto.getCompetitorName());
        c.setCompetitorNumber(dto.getCompetitorNumber());
        c.setPaymentStatus(dto.getPaymentStatus());

        competitorRepository.save(c);

        return new CompetitorDTO(c);
    }

}
