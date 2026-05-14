package com.example.trabalhocotacao;

import jakarta.persistence.*;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
