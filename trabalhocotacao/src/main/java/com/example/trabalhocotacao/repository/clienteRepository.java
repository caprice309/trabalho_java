package com.example.trabalhocotacao.repository;

import com.example.trabalhocotacao.entity.clienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepository extends JpaRepository<clienteEntity, Long> {

}
