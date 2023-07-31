/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.Cliente;
import java.util.List;

import com.example.demo.entity.Trabajador;
import com.example.demo.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface IClienteDao extends JpaRepository<Cliente, Long>{


    public Cliente findByUsuario(Usuario usuario);
    @Query("select c from Cliente c where c.usuario.id=?1")
    public Cliente findByIdSQL(Long usuarioId);
    public List<Cliente> findByClienteId(Long id);
    public Page<Cliente> findAll(Pageable pagination);
}
