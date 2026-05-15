package com.example.trabalhocotacao.repository;

import com.example.trabalhocotacao.entity.reservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface reservaRepository extends JpaRepository<reservaEntity, Long> {

    @Query("SELECT r FROM reservaEntity r WHERE r.cotacao.id = :cotacaoId AND r.id = :reservaId")
    Optional<reservaEntity> findByCotacaoIdAndReservaId(
            @Param("cotacaoId") Long cotacaoId,
            @Param("reservaId") Long reservaId
    );
}