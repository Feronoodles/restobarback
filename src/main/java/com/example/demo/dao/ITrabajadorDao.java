/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.Trabajador;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface ITrabajadorDao extends JpaRepository<Trabajador, Long>{
    public List<Trabajador> findByTrabajadorId(Long id);
    
    public Page<Trabajador> findAll(Pageable paginacion);
}
