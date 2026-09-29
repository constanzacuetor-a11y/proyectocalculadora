package com.example.Calculadora.DTO;

import com.example.Calculadora.Model.TipoOperacion;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperacionRequestDTO {
    private double numero1;
    private double numero2;
    private TipoOperacion tipoOperacion;

}
