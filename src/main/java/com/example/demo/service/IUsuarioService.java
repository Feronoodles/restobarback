/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author User
 */
public interface IUsuarioService {
    public List<Usuario> findAll();
    
    public void save(Usuario usuario);
    
    public Usuario findUsuario(Usuario usuario);
    
    public Usuario checkUsuarioLogin(Usuario usuario);
    
    public void deleteUsuario(Usuario usuario);
    
    public Usuario updateUsuario(Usuario usuario);
    
    public Optional<Usuario> findUsuarioById(Long id);
    
    public void deleteUsuario(Long id);
    
    public void deleteAllUsuarios();

    public Usuario findById(Long id);
    
    public Usuario findByIdSQL(Long id);
    
   
}
