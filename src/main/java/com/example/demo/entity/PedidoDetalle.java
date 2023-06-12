/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "PedidoDetalle")
public class PedidoDetalle implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoDetalleId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Platos plato;
    
    private int cantidadPlatos;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Bebidas bebida;
    
    private int cantidadBebidas;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Pedidos pedido;
    
    public PedidoDetalle(){
        
    }

    public Long getPedidoDetalleId() {
        return pedidoDetalleId;
    }

    public void setPedidoDetalleId(Long pedidoDetalleId) {
        this.pedidoDetalleId = pedidoDetalleId;
    }

    public Platos getPlato() {
        return plato;
    }

    public void setPlato(Platos plato) {
        this.plato = plato;
    }

    public int getCantidadPlatos() {
        return cantidadPlatos;
    }

    public void setCantidadPlatos(int cantidadPlatos) {
        this.cantidadPlatos = cantidadPlatos;
    }

    public Bebidas getBebida() {
        return bebida;
    }

    public void setBebida(Bebidas bebida) {
        this.bebida = bebida;
    }

    public int getCantidadBebidas() {
        return cantidadBebidas;
    }

    public void setCantidadBebidas(int cantidadBebidas) {
        this.cantidadBebidas = cantidadBebidas;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }
    
    
    
    private static final Long serialVersionUID = 1L;
    
    
    
}
