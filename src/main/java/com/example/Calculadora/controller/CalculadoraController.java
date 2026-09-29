package com.example.Calculadora.controller;

import com.example.Calculadora.DTO.OperacionRequestDTO;
import com.example.Calculadora.DTO.OperacionResponseDTO;
import com.example.Calculadora.service.CalculadoraService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @PostMapping("/calcular")
    public OperacionResponseDTO calcular(
            @RequestBody OperacionRequestDTO solicitud) {

        return calculadoraService.procesarOperacion(solicitud);
    }
}