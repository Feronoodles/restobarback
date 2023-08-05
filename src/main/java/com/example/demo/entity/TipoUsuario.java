/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import com.example.demo.model.tipo_usuario.MTipoUsuarioRegistro;
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
@Table(name = "Tipo_Usuario")
public class TipoUsuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoUsuarioId;
    
    @Column(nullable = false)
    private String nombre;

    /**
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipoUsuarioId", referencedColumnName = "tipoUsuario")
    private List<Usuario> usuarios = new ArrayList<>();
**/
    public TipoUsuario(){}
    
    public TipoUsuario(MTipoUsuarioRegistro tipoUsuarioRegistro)
    {
        this.nombre = tipoUsuarioRegistro.nombre();
    }
 
    
    public Long getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    private static final Long serialVersionUID = 1L;
}
