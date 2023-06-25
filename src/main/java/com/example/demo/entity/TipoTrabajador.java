/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import com.example.demo.model.tipo_trabajador.MTipoTrabajadorRegistro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "Tipo_Trabajador")
public class TipoTrabajador implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoTrabajadorId;
    
    @Column(nullable = false)
    private String nombre;
    
        // relacion de 1 a n con pedidos
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipoTrabajadorId", referencedColumnName = "tipoTrabajadorId")
    private List<Trabajador> trabajadores = new ArrayList<>();
    
    
    public TipoTrabajador(){}
    
    public TipoTrabajador(MTipoTrabajadorRegistro tipoTrabajadorRegistro)
    {
        this.nombre = tipoTrabajadorRegistro.nombre();
    }
    
    public Long getTipoTrabajadorId() {
        return tipoTrabajadorId;
    }

    public void setTipoTrabajadorId(Long tipoTrabajadorId) {
        this.tipoTrabajadorId = tipoTrabajadorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
    private static final Long serialVersionUID = 1L;
    
}
