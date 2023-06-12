/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import com.example.demo.model.bebidas.MBebidasRegistro;
import java.io.Serializable;
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

    private String nombre;
    
    private double precio;

    public Bebidas()
    {
        
    }
    public Bebidas(MBebidasRegistro bebidaRegistro)
    {
        this.nombre = bebidaRegistro.nombre();
        this.precio = bebidaRegistro.precio();
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
    
    private static final Long serialVersionUID = 1L;
    
}
