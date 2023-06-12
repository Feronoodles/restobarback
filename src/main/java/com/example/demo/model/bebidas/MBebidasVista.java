
package com.example.demo.model.bebidas;

import com.example.demo.entity.Bebidas;

public record MBebidasVista(
        Long bebidaId,
        String nombre,
        double precio
        ) {
    public MBebidasVista(Bebidas bebidas){
        this(bebidas.getBebidaId(),bebidas.getNombre(),bebidas.getPrecio());
    }
}
