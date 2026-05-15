package com.example.trabalhocotacao.repository;

import com.example.trabalhocotacao.entity.cotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cotacaoRepository extends JpaRepository<cotacaoEntity, Long> {
}
