/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.TipoUsuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author User
 */
public interface ITipoUsuarioService {
    
    public List<TipoUsuario> findAll();
    
    public void saveTipoUsuario(TipoUsuario tusuario);
    
    public List<TipoUsuario> getTipoUsuarios(Long id);
    
    public TipoUsuario updateTipoUsuario(TipoUsuario tusuario);
    
    public TipoUsuario findByIdTipoUsuario(Long id);
}
