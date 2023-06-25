/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;


import com.example.demo.model.cliente.MUsuarioCliente;
import com.example.demo.model.trabajador.MUsuarioTrabajador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name="Usuarios")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   // @Column (unique=true,name="usuarioId")
   // private String usuarioId;
    
    @Column(unique=true,length=60,name="correo",nullable = false)
    private String correo;
    
    @Column(length=20,name="contraseña",nullable = false)
    private String contraseña;
    
    @Column(name="activo",nullable = false)
    private int activo;
    
    @Column(name="token")
    private String token;
    
    @Column(name="tokenCelular")
    private String tokenCelular;
    

    @Column(name="tipoUsuarioId",nullable = false)
    private Long tipoUsuarioId;
    

    
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
   
    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }

   
    
    
    // relacion de 1 a n con pedidos
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    private List<Pedidos> pedidos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId",referencedColumnName = "id")
    private List<Conexion> conexion = new ArrayList<>();

    public Usuario(MUsuarioCliente mucliente)
    {   
        this.correo = mucliente.correo();
        this.contraseña = mucliente.contraseña();
        this.activo = 1;
        this.token = mucliente.token();
        this.tokenCelular = mucliente.tokenCelular();
        this.tipoUsuarioId = mucliente.tipoUsuarioId();
    }
    
    public Usuario(MUsuarioTrabajador muTrabajador)
    {   
        this.correo = muTrabajador.correo();
        this.contraseña = muTrabajador.contraseña();
        this.activo = 1;
        this.token = muTrabajador.token();
        this.tokenCelular = muTrabajador.tokenCelular();
        this.tipoUsuarioId = muTrabajador.tipoUsuarioId();
    }

    public List<Conexion> getConexion() {
        return conexion;
    }

    public void setConexion(List<Conexion> conexion) {
        this.conexion = conexion;
    }
    
    
    
    
    
    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    
    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    

    
    public Usuario()
    {
        
    }

  /**  public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
**/
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenCelular() {
        return tokenCelular;
    }

    public void setTokenCelular(String tokenCelular) {
        this.tokenCelular = tokenCelular;
    }

    public Long getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }
    
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    
    
    
    private static final long serialVersionUID = 1L;
    
}
