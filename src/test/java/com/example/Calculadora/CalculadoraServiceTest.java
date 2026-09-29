package com.example.Calculadora;

import com.example.Calculadora.Model.TipoOperacion;
import com.example.Calculadora.operation.OperacionMatematica;
import com.example.Calculadora.operation.SumaOperacion;
import com.example.Calculadora.operation.RestaOperacion;
import com.example.Calculadora.operation.MultiplicacionOperacion;
import com.example.Calculadora.operation.DIvisionOperacion;
import com.example.Calculadora.service.CalculadoraService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.Calculadora.DTO.OperacionRequestDTO;
import com.example.Calculadora.DTO.OperacionResponseDTO;

import com.example.Calculadora.exception.OperacionInvalidaException;

public class CalculadoraServiceTest {

    @Test
    void deberiaSeleccionarSumaYCalcularResultado() {

        // Arrange
        List<OperacionMatematica> operaciones = List.of(
                new SumaOperacion(),
                new RestaOperacion(),
                new MultiplicacionOperacion(),
                new DIvisionOperacion()
        );

        CalculadoraService service = new CalculadoraService(operaciones);

        // Act
        double resultado = service.calcular(
                7,
                3,
                TipoOperacion.SUMA
        );

        // Assert
        assertEquals(10.0, resultado);
    }

    @Test
    void deberiaSeleccionarRestaYCalcularResultado() {

        // Arrange
        List<OperacionMatematica> operaciones = List.of(
                new SumaOperacion(),
                new RestaOperacion(),
                new MultiplicacionOperacion(),
                new DIvisionOperacion()
        );

        CalculadoraService service = new CalculadoraService(operaciones);

        // Act
        double resultado = service.calcular(
                10,
                4,
                TipoOperacion.RESTA
        );

        // Assert
        assertEquals(6.0, resultado);
    }

    @Test
    void deberiaSeleccionarMultiplicacionYCalcularResultado() {

        // Arrange
        List<OperacionMatematica> operaciones = List.of(
                new SumaOperacion(),
                new RestaOperacion(),
                new MultiplicacionOperacion(),
                new DIvisionOperacion()
        );

        CalculadoraService service = new CalculadoraService(operaciones);

        // Act
        double resultado = service.calcular(
                6,
                5,
                TipoOperacion.MULTIPLICACION
        );

        // Assert
        assertEquals(30.0, resultado);
    }

    @Test
    void deberiaSeleccionarDivisionYCalcularResultado() {

        // Arrange
        List<OperacionMatematica> operaciones = List.of(
                new SumaOperacion(),
                new RestaOperacion(),
                new MultiplicacionOperacion(),
                new DIvisionOperacion()
        );

        CalculadoraService service = new CalculadoraService(operaciones);

        // Act
        double resultado = service.calcular(
                20,
                4,
                TipoOperacion.DIVISION
        );

        // Assert
        assertEquals(5.0, resultado);
    }
    @Test
void deberiaLanzarExcepcionAlIntentarDividirPorCero() {

    // Arrange
    List<OperacionMatematica> operaciones = List.of(
            new SumaOperacion(),
            new RestaOperacion(),
            new MultiplicacionOperacion(),
            new DIvisionOperacion()
    );

    CalculadoraService service = new CalculadoraService(operaciones);

    // Act + Assert
    assertThrows(
            OperacionInvalidaException.class,
            () -> service.calcular(
                    10,
                    0,
                    TipoOperacion.DIVISION
            )
    );
}
@Test
void deberiaProcesarSolicitudYDevolverResultadoEstructurado() {

    // Arrange
    List<OperacionMatematica> operaciones = List.of(
            new SumaOperacion(),
            new RestaOperacion(),
            new MultiplicacionOperacion(),
            new DIvisionOperacion()
    );

    CalculadoraService service = new CalculadoraService(operaciones);

    OperacionRequestDTO solicitud =
            new OperacionRequestDTO(
                    10,
                    5,
                    TipoOperacion.SUMA
            );

    // Act
    OperacionResponseDTO respuesta =
            service.procesarOperacion(solicitud);

    // Assert
    assertEquals(10.0, respuesta.getNumero1());
    assertEquals(5.0, respuesta.getNumero2());
    assertEquals("SUMA", respuesta.getTipoOperacion());
    assertEquals(15.0, respuesta.getResultado());
}
}