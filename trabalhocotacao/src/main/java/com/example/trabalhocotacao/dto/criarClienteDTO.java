package com.example.trabalhocotacao.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record criarClienteDTO (
        @NotBlank(message = "O nome é obrigatório") String nome,

        @Email(message = "O e-mail deve ser válido") String email,

        String telefone,

        String cpf
    ){
}
