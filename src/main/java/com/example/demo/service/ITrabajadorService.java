/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Trabajador;
import com.example.demo.model.trabajador.MUsuarioTrabajador;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author User
 */
public interface ITrabajadorService {
    
    public List<Trabajador> findAll();
    
    public Page<Trabajador> findAll(Pageable paginacion);
    
    public Trabajador save(MUsuarioTrabajador muTrabajador);
    
    public Trabajador buscarTrabajador(Long id);
}
