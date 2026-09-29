package com.example.Calculadora.operation;

import com.example.Calculadora.Model.TipoOperacion;

public interface OperacionMatematica {
    double calcular(double numero1, double numero2);
    TipoOperacion getTipoOperacion();   

}
