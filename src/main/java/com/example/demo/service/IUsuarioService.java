/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Usuario;
import com.example.demo.model.usuario.MUsuarioActualizar;
import com.example.demo.model.usuario.MUsuarioVista;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author User
 */
public interface IUsuarioService {
    public List<Usuario> findAll();
    
    public void save(Usuario usuario);
    
    public Usuario updateUsuario(Usuario usuario);

    public MUsuarioVista actualizarUsuario(MUsuarioActualizar usuario);

    public Usuario findById(Long id);
    
    public Usuario findByIdSQL(Long id);
    
   
}
