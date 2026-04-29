package com.example.trabalhocotacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface reservaRepository extends JpaRepository<reservaEntity, Long> {

    @Query("SELECT r FROM ReservaEntity r WHERE r.destino.id = :destinoId AND r.id = :reservaId")
    Optional<reservaEntity> findByDestinoIdAndReservaId(
            @Param("destinoId") Long destinoId,
            @Param("reservaId") Long reservaId
    );
}