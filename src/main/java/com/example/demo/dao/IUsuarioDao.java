/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author User
 */
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
    
    public UserDetails findByCorreo(String correo);
    
    public Usuario findByCorreoAndContraseña(String correo,String contraseña);
    
   
    
    public Optional<Usuario> findById(Long id);
   
       
   // @Query(value="select u from Usuario u where u.id=id")
    @Query(value="select u from Usuario u where u.id=?1")
    public Usuario findByIdSQL(Long id);
    //@Param("id") 
   

}
