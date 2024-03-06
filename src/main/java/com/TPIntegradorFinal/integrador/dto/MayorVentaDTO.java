package com.TPIntegradorFinal.integrador.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MayorVentaDTO implements Serializable {

    private Long codigo_venta;
    private double total;
    private int cantidadProductos;
    private String nombre;
    private String apellido;

}
