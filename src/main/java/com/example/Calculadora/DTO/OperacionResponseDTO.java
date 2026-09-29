package com.example.Calculadora.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OperacionResponseDTO {
    private Long id;
    private double numero1;
    private double numero2;
    private String tipoOperacion;
    private double resultado;

}
