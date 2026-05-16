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
@RequestMapping("/api/reservas")
public class reservaController {

    @Autowired
    private reservaService service;

    @PostMapping
    public consultarReservaDTO cadastrar(@RequestBody criarReservaDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<consultarReservaDTO> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public consultarReservaDTO buscarPorId(@PathVariable Long id) {
        return service.consultarPorId(id);
    }

    @PutMapping("/{id}")
    public consultarReservaDTO atualizar(@PathVariable Long id, @RequestBody updtReservaDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }
}