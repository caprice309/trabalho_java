package com.example.trabalhocotacao;

public record consultarClienteDTO(

        Long id,

        String nome,

        String email,

        String telefone,

        String cpf
) {
}
