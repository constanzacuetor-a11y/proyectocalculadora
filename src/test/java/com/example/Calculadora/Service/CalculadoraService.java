package com.example.Calculadora.service;

import com.example.Calculadora.Model.TipoOperacion;
import com.example.Calculadora.operation.OperacionMatematica;
import com.example.Calculadora.exception.OperacionInvalidaException;

import org.springframework.stereotype.Service;

import java.util.List;

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
}