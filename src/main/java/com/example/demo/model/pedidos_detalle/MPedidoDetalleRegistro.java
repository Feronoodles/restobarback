/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.pedidos_detalle;


import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
//el si no cuenta con bebida o plato indicar la opcion que se usara
public record MPedidoDetalleRegistro(
       @NotNull(message = "platosId no puede ser null")
       Long platosId,
       @NotNull(message = "cantidad de platos no puede ser null")
       int cantidadPlatos,
       @NotNull(message = "bebidaId no puede ser null")
       Long bebidasId,
       @NotNull(message = "cantidad de bebidas no puede ser null")
       int cantidadBebidas,
       @NotNull(message = "pedidoId no puede ser null")
       Long pedidoId
        ) {
    
}
