package com.example.trabalhocotacao;

import java.time.LocalDateTime;
import java.util.Set;

public record criarCotacaoDTO(

    clienteEntity cliente_id,

    Set<destinoEntity> destino_id,

    LocalDateTime dataIda,

    LocalDateTime dataVolta,

    Integer numeroDePessoas,

    String status
) {
}
