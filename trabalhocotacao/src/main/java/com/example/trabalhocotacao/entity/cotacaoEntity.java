package com.example.trabalhocotacao.entity;

import jakarta.persistence.*;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="cotacoes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class cotacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="cliente_id", nullable = false)
    private clienteEntity cliente;

    @ManyToMany
    @JoinTable(
            name = "cotacao_destino",
            joinColumns = @JoinColumn(name = "cotacao_id"),
            inverseJoinColumns = @JoinColumn(name = "destino_id")
    )
    private Set<destinoEntity> destinos = new HashSet<>();

    private LocalDateTime dataIda;

    private LocalDateTime dataRetorno;

    private Integer numeroDePessoas;

    private BigDecimal valorTotal;

    private String status;

    @Builder.Default
    @OneToMany(mappedBy = "cotacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<descontoEntity> descontos = new ArrayList<>();

    public void adicionarDesconto(descontoEntity desconto) {
        descontos.add(desconto);
        desconto.setCotacao(this);
    }
}
