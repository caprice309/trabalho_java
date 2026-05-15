package com.example.trabalhocotacao.service;

import com.example.trabalhocotacao.repository.*;
import com.example.trabalhocotacao.entity.*;
import com.example.trabalhocotacao.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class clienteService {

    @Autowired
    private clienteRepository repository;

    private consultarClienteDTO toDTO(clienteEntity entity) {
        return new consultarClienteDTO(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getCpf()
        );
    }

    public consultarClienteDTO criar(criarClienteDTO dto) {

        clienteEntity entity = clienteEntity.builder()
                .nome(dto.nome())
                .email(dto.email())
                .telefone(dto.telefone())
                .cpf(dto.cpf())
                .build();

        return toDTO(repository.save(entity));
    }

    public List<consultarClienteDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}