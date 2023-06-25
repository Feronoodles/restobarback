/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import com.example.demo.model.bebidas.MBebidasRegistro;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "Bebidas")
public class Bebidas implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bebidaId;

    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private double precio;
    
    @Column(nullable = false)
    private boolean activo;

    public Bebidas()
    {
        
    }
    public Bebidas(MBebidasRegistro bebidaRegistro)
    {
        this.nombre = bebidaRegistro.nombre();
        this.precio = bebidaRegistro.precio();
        this.activo = true;
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
    
    
    public Long getBebidaId() {
        return bebidaId;
    }

    public void setBebidaId(Long id) {
        this.bebidaId = id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    private static final Long serialVersionUID = 1L;
    
}
