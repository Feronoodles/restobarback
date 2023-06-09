/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.TipoTrabajador;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface ITipoTrabajadorDao extends CrudRepository<TipoTrabajador, Long>{
    
    public List<TipoTrabajador> findByTipoTrabajadorId(Long id);
}
