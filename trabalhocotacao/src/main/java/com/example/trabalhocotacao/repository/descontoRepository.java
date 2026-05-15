package com.example.trabalhocotacao.repository;

import com.example.trabalhocotacao.entity.descontoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface descontoRepository extends JpaRepository<descontoEntity, Long> {
    List<descontoEntity> findByCotacaoId(Long cotacaoId);
}
