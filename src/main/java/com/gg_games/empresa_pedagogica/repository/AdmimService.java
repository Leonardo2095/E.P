package com.gg_games.empresa_pedagogica.repository;

import com.gg_games.empresa_pedagogica.model.AdmimModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AdmimService extends JpaRepository <AdmimModel, Long> {

}
