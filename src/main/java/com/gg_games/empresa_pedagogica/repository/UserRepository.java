package com.gg_games.empresa_pedagogica.repository;

import com.gg_games.empresa_pedagogica.model.UserModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <UserModel, Long> {
    @Override
    <S extends UserModel> S save(S UserModel);


    @Override
    void deleteById(Long userID);

    UserDetails findByUserName(String userName);


}
