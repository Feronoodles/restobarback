
package com.example.demo.model.bebidas;

import com.example.demo.entity.Bebidas;

public record MBebidasVista(
        Long bebidaId,
        String nombre,
        double precio,
        boolean bebida
        ) {
    public MBebidasVista(Bebidas bebidas){
        this(bebidas.getBebidaId(),bebidas.getNombre(),bebidas.getPrecio(),bebidas.isActivo());
    }
}
