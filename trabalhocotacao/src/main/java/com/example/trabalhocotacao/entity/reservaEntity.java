package com.example.trabalhocotacao.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class reservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @OneToOne
    @JoinColumn(name = "cotacao_id", unique = true, nullable = false)
    private cotacaoEntity cotacao;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private destinoEntity destino;
}
