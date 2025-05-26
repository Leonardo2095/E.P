package com.gg_games.empresa_pedagogica.repository;

import com.gg_games.empresa_pedagogica.model.ApostasModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApostasRepository extends JpaRepository<ApostasModel, Long> {

    @Override
    <S extends ApostasModel> S save(S ApostasModel);

    List<ApostasModel> findAllByUser_UserID(Long userid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tb_apostas SET gambleState = :status WHERE gambleID = :id", nativeQuery = true)
    void atualizarStatus(@Param("id") Long id, @Param("status") String status);



}
