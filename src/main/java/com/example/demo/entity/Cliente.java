/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import com.example.demo.model.cliente.MUsuarioCliente;
import java.io.Serializable;
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
@Table(name = "Cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId",unique = true,nullable = false)
    private Usuario usuarios;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String direccion;
    
    @Column(nullable = false)
    private Date fechaNacimiento;
    
    public Cliente()
    {
        
    }
    public Cliente(MUsuarioCliente mucliente)
    {
        this.name = mucliente.name();
        this.direccion = mucliente.direccion();
        this.fechaNacimiento = mucliente.fechaNacimiento();
        
    }

    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public Usuario getUsuario() {
        return usuarios;
    }
    public void setUsuario(Usuario usuarios)
    {
        this.usuarios = usuarios;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    private static final Long serialVersionUID = 1L;
}
