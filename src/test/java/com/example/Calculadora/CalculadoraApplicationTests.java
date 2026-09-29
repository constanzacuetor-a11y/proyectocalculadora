package com.example.Calculadora;

import com.example.Calculadora.operation.SumaOperacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraApplicationTests {

    @Test
    void deberiaSumarDosNumerosCorrectamente() {

        // Arrange
        SumaOperacion sumaOperacion = new SumaOperacion();
        double numero1 = 5;
        double numero2 = 3;

        // Act
        double resultado = sumaOperacion.calcular(numero1, numero2);

        // Assert
        assertEquals(8.0, resultado);
    }
}
