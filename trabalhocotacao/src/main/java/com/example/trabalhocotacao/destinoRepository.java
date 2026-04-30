package com.example.trabalhocotacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface destinoRepository extends JpaRepository<destinoEntity, Long> {

}