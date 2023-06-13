/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model.pedidos_detalle;

import com.example.demo.model.bebidas.MBebidasVista;
import com.example.demo.model.platos.MPlatosVista;

/**
 *
 * @author User
 */
public record MPedidoDetalleRegistro(
       Long platosId,
       int cantidadPlatos,
       Long bebidasId,
       int cantidadBebidas,
       Long pedidoId
        ) {
    
}
