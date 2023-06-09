/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.TipoUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface ITipoUsuarioDao extends CrudRepository<TipoUsuario, Long>{
    
    public List<TipoUsuario> findByTipoUsuarioId(Long id);
    
   
    
    
}
