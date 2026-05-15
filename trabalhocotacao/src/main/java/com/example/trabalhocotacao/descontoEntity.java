package com.example.trabalhocotacao;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="descontos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class descontoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cotacao_id", nullable = false)
    private cotacaoEntity cotacao;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valorDesconto;

    private String descricao;

    private LocalDateTime dataAplicacao;
}
