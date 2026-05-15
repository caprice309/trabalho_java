package com.example.trabalhocotacao.entity;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="pagamentos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class pagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cotacao_id", unique = true)
    private cotacaoEntity cotacao;

    private BigDecimal valorPago;

    private String status;

    private LocalDateTime dataPagamento;

}
