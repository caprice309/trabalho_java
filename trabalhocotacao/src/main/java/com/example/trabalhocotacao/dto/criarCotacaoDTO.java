package com.example.trabalhocotacao.dto;
import java.time.LocalDateTime;
import java.util.Set;

public record criarCotacaoDTO(

    Long cliente_id,

    Set<Long> destino_id,

    LocalDateTime dataIda,

    LocalDateTime dataRetorno,

    Integer numeroDePessoas,

    String status
) {
}
