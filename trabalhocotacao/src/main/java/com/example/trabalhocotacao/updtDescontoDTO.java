package com.example.trabalhocotacao;

import java.math.BigDecimal;

public record updtDescontoDTO(
        BigDecimal valorDesconto,

        String descricao
) {}
