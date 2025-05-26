package com.gg_games.empresa_pedagogica.controller;

import com.gg_games.empresa_pedagogica.dto.CompetitorCreateDTO;
import com.gg_games.empresa_pedagogica.dto.CompetitorDTO;
import com.gg_games.empresa_pedagogica.service.CompetitorService;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/competidor")
public class CompetitorController {

    CompetitorService competitorService;

    public CompetitorController(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @PostMapping("/registro")
    ResponseEntity<CompetitorDTO> criar (@RequestBody CompetitorCreateDTO dto){
        CompetitorDTO competitor = competitorService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(competitor);
    }
}
