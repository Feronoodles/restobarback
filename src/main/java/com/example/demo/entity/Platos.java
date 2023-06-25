/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import com.example.demo.model.platos.MPlatosRegistro;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 *
 * @author User
 */
@Entity
@Table(name = "Platos")
public class Platos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long platosId;
    
    @Column(length = 50,nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private double precio;
    
    @Column(nullable = false)
    private boolean activo;
    //    @ManyToMany
//    @JoinTable(name="Platos_Pedidos",
//            joinColumns = @JoinColumn(name="platosId", referencedColumnName = "platosId"),
//            inverseJoinColumns = @JoinColumn(name="pedidosId",referencedColumnName = "pedidosId"))
//    private Set<Pedidos>pedidos = new HashSet<Pedidos>();

    public Platos(){ }
    
    public Platos(MPlatosRegistro platoRegistro){
        this.nombre = platoRegistro.nombre();
        this.precio = platoRegistro.precio();
        this.activo = true;
    }

    public Long getPlatosId() {
        return platosId;
    }

    public void setPlatosId(Long platosId) {
        this.platosId = platosId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
   // public Set<Pedidos> getPedidos() {
   //     return pedidos;
   // }

  //  public void setPedidos(Set<Pedidos> pedidos) {
  //      this.pedidos = pedidos;
  //  }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    
    
    private static final Long serialVersionUID = 1L;
}
