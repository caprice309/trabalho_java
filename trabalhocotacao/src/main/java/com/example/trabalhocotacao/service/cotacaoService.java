package com.example.trabalhocotacao.service;

import com.example.trabalhocotacao.repository.*;
import com.example.trabalhocotacao.entity.*;
import com.example.trabalhocotacao.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class cotacaoService {

    @Autowired
    private cotacaoRepository repository;

    @Autowired
    private clienteRepository clienteRepo;

    @Autowired
    private destinoRepository destinoRepo;

    private consultarCotacaoDTO toDTO(cotacaoEntity entity) {
        Set<Long> destinosIds = entity.getDestinos().stream()
                .map(destinoEntity::getId)
                .collect(Collectors.toSet());

        List<consultarDescontoDTO> descontosDTO = entity.getDescontos().stream()
                .map(d -> new consultarDescontoDTO(d.getId(), d.getValorDesconto(), d.getDescricao()))
                .collect(Collectors.toList());

        return new consultarCotacaoDTO(
                entity.getId(),
                entity.getCliente() != null ? entity.getCliente().getId() : null,
                destinosIds,
                entity.getDataIda(),
                entity.getDataRetorno(),
                entity.getNumeroDePessoas(),
                entity.getValorTotal(), // Nova variável incluída na resposta
                entity.getStatus(),
                descontosDTO
        );
    }

    public consultarCotacaoDTO criar(criarCotacaoDTO dto) {
        clienteEntity cliente = clienteRepo.findById(dto.cliente_id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + dto.cliente_id()));

        List<destinoEntity> destinosEncontrados = destinoRepo.findAllById(dto.destino_id());
        if (destinosEncontrados.isEmpty()) {
            throw new RuntimeException("É necessário informar ao menos um destino válido para a cotação.");
        }
        Set<destinoEntity> destinos = new HashSet<>(destinosEncontrados);

        BigDecimal precoSomaDestinos = destinos.stream()
                .map(destinoEntity::getPrecoPorPessoa)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal valorTotalCalculado = precoSomaDestinos.multiply(BigDecimal.valueOf(dto.numeroDePessoas()));

        cotacaoEntity entity = cotacaoEntity.builder()
                .cliente(cliente)
                .destinos(destinos)
                .dataIda(dto.dataIda())
                .dataRetorno(dto.dataRetorno())
                .numeroDePessoas(dto.numeroDePessoas())
                .valorTotal(valorTotalCalculado)
                .status(dto.status() != null ? dto.status().toUpperCase() : "PENDENTE")
                .build();

        return toDTO(repository.save(entity));
    }

    public List<consultarCotacaoDTO> listarTodas() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public consultarCotacaoDTO consultarPorId(Long id) {
        cotacaoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cotação não encontrada com o ID: " + id));
        return toDTO(entity);
    }

    public consultarCotacaoDTO atualizarStatus(Long id, String novoStatus) {
        cotacaoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cotação não encontrada com o ID: " + id));

        entity.setStatus(novoStatus.toUpperCase());
        return toDTO(repository.save(entity));
    }

    public void excluir(Long id) {
        cotacaoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cotação não encontrada com o ID: " + id));
        repository.delete(entity);
    }
}