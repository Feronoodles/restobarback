/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Pedidos;
import java.util.List;

/**
 *
 * @author User
 */
public interface IPedidosService {
    
    public List<Pedidos> findAll();
    
    public void savePedidos(Pedidos pe);
    
    public List<Pedidos> getPedidosUsuarios(Long id);
    
    public Pedidos getPedidoBySQL(Long pedidosId);
}
