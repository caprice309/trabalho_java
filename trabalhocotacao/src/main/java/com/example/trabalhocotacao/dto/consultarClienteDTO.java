package com.example.trabalhocotacao.dto;

public record consultarClienteDTO(

        Long id,

        String nome,

        String email,

        String telefone,

        String cpf
) {
}
