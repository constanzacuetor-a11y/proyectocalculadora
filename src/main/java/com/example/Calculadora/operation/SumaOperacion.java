package com.example.Calculadora.operation;

import com.example.Calculadora.Model.TipoOperacion;
import org.springframework.stereotype.Component;

@Component

public class SumaOperacion implements OperacionMatematica {
    @Override
    public double calcular(double numero1, double numero2) {
        return numero1 + numero2;
    }

    @Override
    public TipoOperacion getTipoOperacion() {
        return TipoOperacion.SUMA;
    }   
}
