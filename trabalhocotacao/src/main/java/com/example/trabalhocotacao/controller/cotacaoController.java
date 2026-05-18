package com.example.trabalhocotacao.controller;

import com.example.trabalhocotacao.repository.*;
import com.example.trabalhocotacao.entity.*;
import com.example.trabalhocotacao.dto.*;
import com.example.trabalhocotacao.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cotacoes")
public class cotacaoController {

    @Autowired
    private cotacaoService service;

    @PostMapping
    public consultarCotacaoDTO cadastrar(@RequestBody criarCotacaoDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<consultarCotacaoDTO> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public consultarCotacaoDTO buscarPorId(@PathVariable Long id) {
        return service.consultarPorId(id);
    }

    @PatchMapping("/{id}/status")
    public consultarCotacaoDTO atualizarStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
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
