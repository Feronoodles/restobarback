/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.TipoUsuario;
import com.example.demo.model.tipo_usuario.MTipoUsuarioVista;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface ITipoUsuarioDao extends JpaRepository<TipoUsuario, Long>{
    
    public List<TipoUsuario> findByTipoUsuarioId(Long id);

    public TipoUsuario findByNombre(String nombre);
    
   // @Query("select new com.example.demo.model.MTipoUsuarioVista(t.tipoUsuarioId,t.nombre) from Tipo_Usuario t")
   // public List<MTipoUsuarioVista> findDetails();
    
    
}
