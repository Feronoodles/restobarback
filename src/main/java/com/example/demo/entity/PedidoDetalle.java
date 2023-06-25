/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import com.example.demo.model.pedidos_detalle.MPedidoDetalleRegistro;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    
    @Column(nullable = false)
    private Long pedidosId;
    
    public PedidoDetalle(){
        
    }
    public PedidoDetalle(MPedidoDetalleRegistro pedidoDetalleRegistro,Platos plato,Bebidas bebida)
    {
        this.plato = plato;
        this.cantidadPlatos = pedidoDetalleRegistro.cantidadPlatos();
        this.bebida = bebida;
        this.cantidadBebidas = pedidoDetalleRegistro.cantidadBebidas();
        this.pedidosId = pedidoDetalleRegistro.pedidoId();
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

    public Long getpedidoId() {
        return pedidosId;
    }

    public void setPedido(Long pedidosId) {
        this.pedidosId = pedidosId;
    }
    
    
    
    private static final Long serialVersionUID = 1L;
    
    
    
}
