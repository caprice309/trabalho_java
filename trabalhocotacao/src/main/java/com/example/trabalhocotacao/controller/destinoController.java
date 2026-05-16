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
@RequestMapping("/api/destinos")
public class destinoController {

    @Autowired
    private destinoService service;

    @PostMapping
    public consultarDestinoDTO cadastrar(@RequestBody criarDestinoDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<consultarDestinoDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public consultarDestinoDTO buscarPorId(@PathVariable Long id) {
        return service.consultarPorId(id);
    }

    @PutMapping("/{id}")
    public consultarDestinoDTO atualizar(@PathVariable Long id, @RequestBody updtDestinoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }
}