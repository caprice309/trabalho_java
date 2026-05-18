package com.example.trabalhocotacao.controller;

import com.example.trabalhocotacao.repository.*;
import com.example.trabalhocotacao.entity.*;
import com.example.trabalhocotacao.dto.*;
import com.example.trabalhocotacao.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pagamentos")
public class pagamentoController {

    @Autowired
    private pagamentoService service;

    @PostMapping
    public consultarPagamentoDTO registrar(@RequestBody criarPagamentoDTO dto) {
        return service.registrar(dto);
    }

    @GetMapping("/{id}")
    public consultarPagamentoDTO buscarPorId(@PathVariable Long id) {
        return service.consultarPorId(id);
    }

    @PatchMapping("/{id}/status")
    public consultarPagamentoDTO atualizarStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String novoStatus = body.get("status");
        if (novoStatus == null) {
            throw new RuntimeException("O campo 'status' é obrigatório no corpo da requisição.");
        }
        return service.atualizarStatus(id, novoStatus);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }
}
