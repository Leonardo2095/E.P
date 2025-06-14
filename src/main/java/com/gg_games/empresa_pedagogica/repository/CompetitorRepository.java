package com.gg_games.empresa_pedagogica.repository;

import com.gg_games.empresa_pedagogica.model.CompetitorModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
public interface CompetitorRepository extends JpaRepository<CompetitorModel , Long> {

    @Override
    <S extends CompetitorModel> S save(S CompetitorModel);
}
