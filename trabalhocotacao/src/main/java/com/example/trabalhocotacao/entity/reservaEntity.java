package com.example.trabalhocotacao.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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

    LocalDateTime dataViagem;

    @OneToOne
    @JoinColumn(name = "cotacao_id", unique = true, nullable = false)
    private cotacaoEntity cotacao;

}
