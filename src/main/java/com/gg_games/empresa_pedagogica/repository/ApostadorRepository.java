package com.gg_games.empresa_pedagogica.repository;

import com.gg_games.empresa_pedagogica.model.ApostadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApostadorRepository  extends JpaRepository <ApostadorModel, Long> {
    @Override
    <S extends ApostadorModel> S save(S ApostadorModel);

    @Override
    Optional<ApostadorModel> findById(Long aLong);


}
