/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.Pedidos;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface IPedidosDao extends JpaRepository<Pedidos, Long>{
    public Page<Pedidos> findAll(Pageable paginacion);
    
    public Page<Pedidos> findByUsuarioId(Pageable pagination,Long id);
    
    @Query(value = "select p from Pedidos p where p.pedidosId=?1")
    public Pedidos findPedidoBySQL(Long pedidosId);
   
}
