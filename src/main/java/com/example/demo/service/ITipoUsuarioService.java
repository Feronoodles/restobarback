/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.TipoUsuario;
import com.example.demo.model.tipo_usuario.MTipoUsuarioRegistro;
import com.example.demo.model.tipo_usuario.MTipoUsuarioVista;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author User
 */
public interface ITipoUsuarioService {
    
    public Page<TipoUsuario> findAll(Pageable paginacion);
    
    public TipoUsuario saveTipoUsuario(MTipoUsuarioRegistro tusuario);
    
    public List<TipoUsuario> getTipoUsuarios(Long id);
    
    public TipoUsuario updateTipoUsuario(TipoUsuario tusuario);
    
    public TipoUsuario findByIdTipoUsuario(Long id);
}
