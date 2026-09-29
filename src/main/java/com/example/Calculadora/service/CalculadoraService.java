package com.example.Calculadora.service;

import com.example.Calculadora.Model.TipoOperacion;
import com.example.Calculadora.operation.OperacionMatematica;
import com.example.Calculadora.exception.OperacionInvalidaException;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.Calculadora.DTO.OperacionRequestDTO;
import com.example.Calculadora.DTO.OperacionResponseDTO;

@Service
public class CalculadoraService {

    private final List<OperacionMatematica> operaciones;

    public CalculadoraService(List<OperacionMatematica> operaciones) {
        this.operaciones = operaciones;
    }

    public double calcular(
            double numero1,
            double numero2,
            TipoOperacion tipoOperacion) {

        for (OperacionMatematica operacion : operaciones) {

            if (operacion.getTipoOperacion() == tipoOperacion) {
                return operacion.calcular(numero1, numero2);
            }
        }

        throw new OperacionInvalidaException(
                "La operación solicitada no es válida"
        );
    }
    public OperacionResponseDTO procesarOperacion(OperacionRequestDTO solicitud) {

    double resultado = calcular(
            solicitud.getNumero1(),
            solicitud.getNumero2(),
            solicitud.getTipoOperacion()
    );

    return OperacionResponseDTO.builder()
            .numero1(solicitud.getNumero1())
            .numero2(solicitud.getNumero2())
            .tipoOperacion(solicitud.getTipoOperacion().name())
            .resultado(resultado)
            .build();
}
}