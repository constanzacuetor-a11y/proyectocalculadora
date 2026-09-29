package com.example.Calculadora;

import com.example.Calculadora.operation.SumaOperacion;
import com.example.Calculadora.operation.RestaOperacion;
import com.example.Calculadora.operation.MultiplicacionOperacion;
import com.example.Calculadora.operation.DIvisionOperacion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.Calculadora.exception.OperacionInvalidaException;

public class OperacionMatematicaTest {

    @Test
    void deberiaSumarDosNumerosCorrectamente() {

        // Arrange
        SumaOperacion operacion = new SumaOperacion();
        double numero1 = 5;
        double numero2 = 3;

        // Act
        double resultado = operacion.calcular(numero1, numero2);

        // Assert
        assertEquals(8.0, resultado);
    }

    @Test
    void deberiaRestarDosNumerosCorrectamente() {

        // Arrange
        RestaOperacion operacion = new RestaOperacion();
        double numero1 = 10;
        double numero2 = 4;

        // Act
        double resultado = operacion.calcular(numero1, numero2);

        // Assert
        assertEquals(6.0, resultado);
    }

    @Test
    void deberiaMultiplicarDosNumerosCorrectamente() {

        // Arrange
        MultiplicacionOperacion operacion = new MultiplicacionOperacion();
        double numero1 = 5;
        double numero2 = 4;

        // Act
        double resultado = operacion.calcular(numero1, numero2);

        // Assert
        assertEquals(20.0, resultado);
    }

    @Test
    void deberiaDividirDosNumerosCorrectamente() {

        // Arrange
        DIvisionOperacion operacion = new DIvisionOperacion();
        double numero1 = 10;
        double numero2 = 2;

        // Act
        double resultado = operacion.calcular(numero1, numero2);

        // Assert
        assertEquals(5.0, resultado);
    }

    @Test
    void deberiaLanzarExcepcionAlDividirPorCero() {

        // Arrange
        DIvisionOperacion operacion = new DIvisionOperacion();
        double numero1 = 10;
        double numero2 = 0;

        // Act + Assert
        assertThrows(
    OperacionInvalidaException.class,
    () -> operacion.calcular(numero1, numero2)
);
    }

    @Test
    void deberiaSumarNumerosNegativos() {

        // Arrange
        SumaOperacion operacion = new SumaOperacion();
        double numero1 = -5;
        double numero2 = 3;

        // Act
        double resultado = operacion.calcular(numero1, numero2);

        // Assert
        assertEquals(-2.0, resultado);
    }

    @Test
    void deberiaMultiplicarNumerosDecimales() {

        // Arrange
        MultiplicacionOperacion operacion = new MultiplicacionOperacion();
        double numero1 = 2.5;
        double numero2 = 4;

        // Act
        double resultado = operacion.calcular(numero1, numero2);

        // Assert
        assertEquals(10.0, resultado);
    }

    @Test
    void deberiaDividirCeroPorUnNumero() {

        // Arrange
        DIvisionOperacion operacion = new DIvisionOperacion();
        double numero1 = 0;
        double numero2 = 5;

        // Act
        double resultado = operacion.calcular(numero1, numero2);

        // Assert
        assertEquals(0.0, resultado);
    }
}