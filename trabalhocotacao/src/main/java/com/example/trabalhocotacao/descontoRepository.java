package com.example.trabalhocotacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface descontoRepository extends JpaRepository<descontoEntity, Long> {
    List<descontoEntity> findByCotacaoId(Long cotacaoId);
}
