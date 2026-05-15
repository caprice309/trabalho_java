package com.example.trabalhocotacao.repository;

import com.example.trabalhocotacao.entity.destinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface destinoRepository extends JpaRepository<destinoEntity, Long> {

}