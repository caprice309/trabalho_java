package com.example.trabalhocotacao.service;

import com.example.trabalhocotacao.repository.*;
import com.example.trabalhocotacao.entity.*;
import com.example.trabalhocotacao.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class destinoService {

    @Autowired
    private destinoRepository repository;

    private consultarDestinoDTO toDTO(destinoEntity entity) {
        return new consultarDestinoDTO(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getPrecoPorPessoa(),
                entity.getCategoria()
        );
    }

    public consultarDestinoDTO criar(criarDestinoDTO dto) {
        destinoEntity entity = destinoEntity.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .precoPorPessoa(dto.precoPorPessoa())
                .categoria(dto.categoria())
                .build();

        return toDTO(repository.save(entity));
    }

    public List<consultarDestinoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public consultarDestinoDTO consultarPorId(Long id) {
        destinoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destino não encontrado com o ID: " + id));
        return toDTO(entity);
    }

    public consultarDestinoDTO atualizar(Long id, updtDestinoDTO dto) {
        destinoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destino não encontrado com o ID: " + id));

        entity.setNome(dto.nome());
        entity.setDescricao(dto.descricao());
        entity.setPrecoPorPessoa(dto.precoPorPessoa());

        return toDTO(repository.save(entity));
    }

    public void excluir(Long id) {
        destinoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destino não encontrado com o ID: " + id));

        repository.delete(entity);
    }
}