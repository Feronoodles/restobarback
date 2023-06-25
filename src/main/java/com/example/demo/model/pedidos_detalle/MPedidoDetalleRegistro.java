/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.pedidos_detalle;

import com.example.demo.model.bebidas.MBebidasVista;
import com.example.demo.model.platos.MPlatosVista;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
public record MPedidoDetalleRegistro(
       @NotNull
       Long platosId,
       @NotNull
       int cantidadPlatos,
       @NotNull
       Long bebidasId,
       @NotNull
       int cantidadBebidas,
       @NotNull
       Long pedidoId
        ) {
    
}
