package com.example.Calculadora;

import com.example.Calculadora.Model.TipoOperacion;
import com.example.Calculadora.operation.OperacionMatematica;
import com.example.Calculadora.operation.SumaOperacion;
import com.example.Calculadora.service.CalculadoraService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraServiceTest {

    @Test
    void deberiaSeleccionarSumaYCalcularResultado() {

        // Arrange
        OperacionMatematica suma = new SumaOperacion();

        CalculadoraService service =
                new CalculadoraService(List.of(suma));

        double numero1 = 7;
        double numero2 = 3;
        TipoOperacion tipo = TipoOperacion.SUMA;

        // Act
        double resultado =
                service.calcular(numero1, numero2, tipo);

        // Assert
        assertEquals(10.0, resultado);
    }
}