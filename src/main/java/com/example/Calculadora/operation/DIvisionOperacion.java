package com.example.Calculadora.operation;

import com.example.Calculadora.Model.TipoOperacion;
import org.springframework.stereotype.Component;

import com.example.Calculadora.exception.OperacionInvalidaException;

@Component
public class DIvisionOperacion implements OperacionMatematica {

    @Override
    public double calcular(double numero1, double numero2) {
       if (numero2 == 0) {
    throw new OperacionInvalidaException("No se puede dividir por cero");
}

        return numero1 / numero2;
    }

    @Override
    public TipoOperacion getTipoOperacion() {
        return TipoOperacion.DIVISION;
    }
}