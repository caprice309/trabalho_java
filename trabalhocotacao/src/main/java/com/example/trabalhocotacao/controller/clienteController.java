package com.example.trabalhocotacao.controller;

import com.example.trabalhocotacao.repository.*;
import com.example.trabalhocotacao.entity.*;
import com.example.trabalhocotacao.dto.*;
import com.example.trabalhocotacao.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class clienteController {

    @Autowired
    private clienteService service;

    @PostMapping
    public consultarClienteDTO cadastrar(@RequestBody criarClienteDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<consultarClienteDTO> listar() {
        return service.listarTodos();
    }
}