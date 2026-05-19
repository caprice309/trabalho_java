package com.example.trabalhocotacao.service;

import com.example.trabalhocotacao.repository.*;
import com.example.trabalhocotacao.entity.*;
import com.example.trabalhocotacao.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class reservaService{

    @Autowired
    private reservaRepository repository;

    @Autowired
    private cotacaoRepository cotacaoRepo;

    private consultarReservaDTO toDTO(reservaEntity entity) {
        return new consultarReservaDTO(
                entity.getId(),
                entity.getCotacao() != null ? entity.getCotacao().getId() : null,
                entity.getDataViagem(),
                entity.getStatus()
        );
    }

    public consultarReservaDTO criar(criarReservaDTO dto) {
        cotacaoEntity cotacao = cotacaoRepo.findById(dto.cotacao_id())
                .orElseThrow(() -> new RuntimeException("Cotação não encontrada com o ID: " + dto.cotacao_id()));

        reservaEntity entity = reservaEntity.builder()
                .status(dto.status())
                .dataViagem(dto.dataViagem())
                .cotacao(cotacao)
                .build();

        return toDTO(repository.save(entity));
    }

    public List<consultarReservaDTO> listarTodas() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public consultarReservaDTO consultarPorId(Long id) {
        reservaEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));
        return toDTO(entity);
    }

    public consultarReservaDTO atualizar(Long id, updtReservaDTO dto) {
        reservaEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));

        entity.setStatus(dto.status());

        return toDTO(repository.save(entity));
    }

    public void excluir(Long id) {
        reservaEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));

        repository.delete(entity);
    }
}
