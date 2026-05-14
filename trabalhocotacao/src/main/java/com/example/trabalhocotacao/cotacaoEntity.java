package com.example.trabalhocotacao;

import jakarta.persistence.*;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
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

    @PositiveOrZero(message = "O preço deve ser positivo")
    @Column(precision = 10, scale = 2)
    private BigDecimal precoPorData;

    private LocalDateTime dataIda;

    private LocalDateTime dataRetorno;

    private Integer numeroDePessoas;

    private BigDecimal valorTotal;

    private String status;
}
