package com.example.trabalhocotacao.service;

import com.example.trabalhocotacao.repository.*;
import com.example.trabalhocotacao.entity.*;
import com.example.trabalhocotacao.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class descontoService {

    @Autowired
    private descontoRepository repository;

    @Autowired
    private cotacaoRepository cotacaoRepo;

    private consultarDescontoDTO toDTO(descontoEntity entity) {
        return new consultarDescontoDTO(
                entity.getId(),
                entity.getValorDesconto(),
                entity.getDescricao()
        );
    }

    public consultarDescontoDTO registrar(criarDescontoDTO dto) {
        cotacaoEntity cotacao = cotacaoRepo.findById(dto.cotacao_id())
                .orElseThrow(() -> new RuntimeException("Cotação não encontrada com o ID: " + dto.cotacao_id()));

        descontoEntity entity = descontoEntity.builder()
                .valorDesconto(dto.valorDesconto())
                .descricao(dto.descricao())
                .cotacao(cotacao)
                .build();

        if (cotacao.getValorTotal() != null) {
            cotacao.setValorTotal(cotacao.getValorTotal().subtract(dto.valorDesconto()));
            cotacaoRepo.save(cotacao);
        }

        return toDTO(repository.save(entity));
    }

    public List<consultarDescontoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public consultarDescontoDTO consultarPorId(Long id) {
        descontoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desconto não encontrado com o ID: " + id));
        return toDTO(entity);
    }

    public List<consultarDescontoDTO> listarPorCotacao(Long cotacaoId) {
        return repository.findAll().stream()
                .filter(d -> d.getCotacao() != null && d.getCotacao().getId().equals(cotacaoId))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public consultarDescontoDTO atualizar(Long id, updtDescontoDTO dto) {
        descontoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desconto não encontrado com o ID: " + id));

        cotacaoEntity cotacao = entity.getCotacao();
        if (cotacao != null && cotacao.getValorTotal() != null) {
            cotacao.setValorTotal(cotacao.getValorTotal().add(entity.getValorDesconto()).subtract(dto.valorDesconto()));
            cotacaoRepo.save(cotacao);
        }

        entity.setValorDesconto(dto.valorDesconto());
        entity.setDescricao(dto.descricao());

        return toDTO(repository.save(entity));
    }

    public void excluir(Long id) {
        descontoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desconto não encontrado com o ID: " + id));

        cotacaoEntity cotacao = entity.getCotacao();
        if (cotacao != null && cotacao.getValorTotal() != null) {
            cotacao.setValorTotal(cotacao.getValorTotal().add(entity.getValorDesconto()));
            cotacaoRepo.save(cotacao);
        }

        repository.delete(entity);
    }
}