package com.gg_games.empresa_pedagogica.repository;

import com.gg_games.empresa_pedagogica.model.ApostasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApostasRepository extends JpaRepository<ApostasModel, Long> {

    @Override
    <S extends ApostasModel> S save(S ApostasModel);

    List<ApostasModel> findAllByGambler_GamblerID(Long gamblerid);

}
