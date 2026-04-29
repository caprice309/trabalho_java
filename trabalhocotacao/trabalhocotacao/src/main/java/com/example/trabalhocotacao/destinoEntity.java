package com.example.trabalhocotacao;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import jdk.jfr.Category;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="products")
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

    @ElementCollection(targetClass = Category.class)
    @CollectionTable(name = "destino_categorias", joinColumns = @JoinColumn(name = "destino_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private Set<Category> categoria = new HashSet<>();

    private String destino;

    @PositiveOrZero(message = "O preço deve ser positivo")
    @Column(precision = 10, scale = 2)
    private BigDecimal precoPorPessoa;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL)
    private List<reservaEntity> reservas;

}