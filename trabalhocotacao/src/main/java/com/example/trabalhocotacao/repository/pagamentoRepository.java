package com.example.trabalhocotacao.repository;

import com.example.trabalhocotacao.entity.pagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pagamentoRepository extends JpaRepository<pagamentoEntity, Long> {
}
