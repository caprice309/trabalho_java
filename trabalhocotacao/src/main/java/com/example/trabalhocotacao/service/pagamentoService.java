package com.example.trabalhocotacao.service;

import com.example.trabalhocotacao.repository.*;
import com.example.trabalhocotacao.entity.*;
import com.example.trabalhocotacao.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class pagamentoService {

    @Autowired
    private pagamentoRepository repository;

    @Autowired
    private cotacaoRepository cotacaoRepo;

    private consultarPagamentoDTO toDTO(pagamentoEntity entity) {
        return new consultarPagamentoDTO(
                entity.getId(),
                entity.getCotacao() != null ? entity.getCotacao().getId() : null,
                entity.getValorPago(),
                entity.getDataPagamento(),
                entity.getStatus()
        );
    }

    public consultarPagamentoDTO registrar(criarPagamentoDTO dto) {
        cotacaoEntity cotacao = cotacaoRepo.findById(dto.cotacao_id())
                .orElseThrow(() -> new RuntimeException("Cotação não encontrada com o ID: " + dto.cotacao_id()));

        // Constrói a entidade de pagamento utilizando o padrão Builder
        pagamentoEntity entity = pagamentoEntity.builder()
                .cotacao(cotacao)
                .valorPago(dto.valorPago())
                .dataPagamento(LocalDateTime.now())
                .status("PENDENTE")
                .build();

        return toDTO(repository.save(entity));
    }

    public consultarPagamentoDTO consultarPorId(Long id) {
        pagamentoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com o ID: " + id));
        return toDTO(entity);
    }

    public consultarPagamentoDTO atualizarStatus(Long id, String novoStatus) {
        pagamentoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com o ID: " + id));

        entity.setStatus(novoStatus.toUpperCase());
        return toDTO(repository.save(entity));
    }

    public void excluir(Long id) {
        pagamentoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com o ID: " + id));
        repository.delete(entity);
    }
}
