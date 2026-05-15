package com.example.trabalhocotacao;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import com.example.trabalhocotacao.categoria;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name="destino")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class destinoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ElementCollection(targetClass = categoria.class)
    @CollectionTable(name = "destino_categorias", joinColumns = @JoinColumn(name = "destino_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private Set<categoria> categoria = new HashSet<>();

    private String destino;

    @PositiveOrZero(message = "O preço deve ser positivo")
    @Column(precision = 10, scale = 2)
    private BigDecimal precoPorPessoa;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL)
    private List<reservaEntity> reservas;

    @ManyToMany(mappedBy = "destinos")
    private Set<cotacaoEntity> cotacoes = new HashSet<>();

}