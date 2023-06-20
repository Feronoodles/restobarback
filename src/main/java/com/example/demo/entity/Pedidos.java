/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import com.example.demo.model.pedidos.MPedidoActualizar;
import com.example.demo.model.pedidos.MPedidoRegistro;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Pedidos")
public class Pedidos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidosId;
    
    private Long usuarioId;
    
    private double gastoTotal;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedidoId")
    private Mesa mesa;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedidosId",referencedColumnName = "pedidosId")
    private List<PedidoDetalle> pedidoDetalle = new ArrayList<>();
    
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

 
   
    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }

    public Pedidos(){}
    
    public Pedidos(MPedidoRegistro pedidoRegistro,Mesa mesa)
    {
        this.usuarioId = pedidoRegistro.usuarioId();
        this.gastoTotal = 0;
        this.mesa = mesa;
        
    }
    public void actualizarPedidos(MPedidoActualizar pedidoActualizar,Mesa mesa){
        if(pedidoActualizar.usuarioId()!=null)
            this.usuarioId = pedidoActualizar.usuarioId();
        if(pedidoActualizar.gastoTotal()>0)
            this.gastoTotal+=pedidoActualizar.gastoTotal();
        if(pedidoActualizar.numeroMesa()>0)
            this.mesa = mesa;
            
    }
    public Long getPedidosId() {
        return pedidosId;
    }

    public void setPedidosId(Long pedidosId) {
        this.pedidosId = pedidosId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
       public List<PedidoDetalle> getPedidoDetalle() {
        return pedidoDetalle;
    }

    public void setPedidoDetalle(List<PedidoDetalle> pedidoDetalle) {
        this.pedidoDetalle = pedidoDetalle;
    }
    //metodo para añadir de muchos a muchos diferentes platos al pedido
 //   public void addPedidosPlatos(Platos plato)
  //  {
  //      this.platos.add(plato);
  //  }
    
    
    private static final Long serialVersionUID = 1L;
    
}
