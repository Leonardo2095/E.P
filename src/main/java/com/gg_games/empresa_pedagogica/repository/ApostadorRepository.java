package com.gg_games.empresa_pedagogica.repository;

import com.gg_games.empresa_pedagogica.model.ApostadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApostadorRepository  extends JpaRepository <ApostadorModel, Long> {

}
