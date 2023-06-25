/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;


import com.example.demo.model.trabajador.MUsuarioTrabajador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "Trabajador")
public class Trabajador implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trabajadorId;
    
    @Column(nullable = false)
    private String nombre;
    
    // relacion de 1 a n con pedidos
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id", referencedColumnName = "trabajadorId",unique = true)
    //private List<Usuario> usuario;
    
    @Column(nullable = false)
    private String direccion;
    
    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private Date fechaInicioTrabajo;
    
    @Column(nullable = false)
    private double salario;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId", unique = true,nullable = false)
    private Usuario usuario;
    
    @Column(name="tipoTrabajadorId",nullable = false)
    private Long tipoTrabajadorId;

    public Trabajador()
    {
        
    }
    
    public Trabajador(MUsuarioTrabajador muTrabajador,Usuario usuario)
    {
        this.nombre = muTrabajador.nombre();
        this.direccion = muTrabajador.direccion();
        this.fechaNacimiento = muTrabajador.fechaNacimiento();
        this.fechaInicioTrabajo = muTrabajador.fechaInicioTrabajo();
        this.salario = muTrabajador.salario();
        this.usuario = usuario;
        this.tipoTrabajadorId = muTrabajador.tipoTrabajadorId();
    }
    
    public Long getTipoTrabajadorId() {
        return tipoTrabajadorId;
    }

    public void setTipoTrabajadorId(Long tipoTrabajadorId) {
        this.tipoTrabajadorId = tipoTrabajadorId;
    }
    public Long getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(Long trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuarios) {
        this.usuario = usuarios;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaInicioTrabajo() {
        return fechaInicioTrabajo;
    }

    public void setFechaInicioTrabajo(Date fechaInicioTrabajo) {
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
  
    private static final long serialVersionUID = 1L;
}
