package com.example.Calculadora;

import com.example.Calculadora.DTO.OperacionRequestDTO;
import com.example.Calculadora.DTO.OperacionResponseDTO;
import com.example.Calculadora.Model.TipoOperacion;
import com.example.Calculadora.controller.CalculadoraController;
import com.example.Calculadora.operation.DIvisionOperacion;
import com.example.Calculadora.operation.MultiplicacionOperacion;
import com.example.Calculadora.operation.OperacionMatematica;
import com.example.Calculadora.operation.RestaOperacion;
import com.example.Calculadora.operation.SumaOperacion;
import com.example.Calculadora.service.CalculadoraService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraControllerTest {

    @Test
    void deberiaRecibirSolicitudYDevolverResultadoCorrecto() {

        // Arrange
        List<OperacionMatematica> operaciones = List.of(
                new SumaOperacion(),
                new RestaOperacion(),
                new MultiplicacionOperacion(),
                new DIvisionOperacion()
        );

        CalculadoraService service =
                new CalculadoraService(operaciones);

        CalculadoraController controller =
                new CalculadoraController(service);

        OperacionRequestDTO solicitud =
                new OperacionRequestDTO(
                        12,
                        8,
                        TipoOperacion.SUMA
                );

        // Act
        OperacionResponseDTO respuesta =
                controller.calcular(solicitud);

        // Assert
        assertEquals(12.0, respuesta.getNumero1());
        assertEquals(8.0, respuesta.getNumero2());
        assertEquals("SUMA", respuesta.getTipoOperacion());
        assertEquals(20.0, respuesta.getResultado());
    }
}