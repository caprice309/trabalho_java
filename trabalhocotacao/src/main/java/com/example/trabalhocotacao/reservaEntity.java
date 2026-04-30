package com.example.trabalhocotacao;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

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

    private String nomeCliente;

    private LocalDate dataViagem;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private destinoEntity destino;
}
