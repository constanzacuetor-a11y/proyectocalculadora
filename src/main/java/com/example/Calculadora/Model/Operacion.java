package com.example.Calculadora.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "operaciones")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Operacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @Column(nullable = false)
    private double numero1;

    @Column(nullable = false)
    private double numero2; 

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoOperacion tipoOperacion;

    @Column(nullable = false)
    private double resultado;

}
