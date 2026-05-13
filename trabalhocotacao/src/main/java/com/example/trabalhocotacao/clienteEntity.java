package com.example.trabalhocotacao;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name="clientes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class clienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Pattern(regexp = "^\\d+$", message = "O telefone deve conter apenas números")
    @Size (min = 10, max = 11, message = "O telefone deve conter entre 10 e 11 números")
    private String telefone;

    @Pattern(regexp = "^\\d+$", message = "O CPF deve conter apenas números")
    @Size (min = 11, max = 11, message = "O CPF deve conter 11 números")
    private String cpf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<cotacaoEntity> cotacao;
}
