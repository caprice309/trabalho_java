package com.example.trabalhocotacao.controller;

import com.example.trabalhocotacao.repository.*;
import com.example.trabalhocotacao.entity.*;
import com.example.trabalhocotacao.dto.*;
import com.example.trabalhocotacao.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descontos")
public class descontoController {

    @Autowired
    private descontoService service;

    @PostMapping
    public consultarDescontoDTO registrar(@RequestBody criarDescontoDTO dto) {
        return service.registrar(dto);
    }

    @GetMapping
    public List<consultarDescontoDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public consultarDescontoDTO buscarPorId(@PathVariable Long id) {
        return service.consultarPorId(id);
    }

    @GetMapping("/cotacao/{cotacao_id}")
    public List<consultarDescontoDTO> listarPorCotacao(@PathVariable Long cotacao_id) {
        return service.listarPorCotacao(cotacao_id);
    }

    @PutMapping("/{id}")
    public consultarDescontoDTO atualizar(@PathVariable Long id, @RequestBody updtDescontoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }
}
