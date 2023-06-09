/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.mapper;

import com.example.demo.entity.Usuario;
import com.example.demo.model.MUsuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("mapper")
public class Mapper {
    public static List<MUsuario> convertirLista(List<Usuario> usuarios)
    {
        List<MUsuario> mUsuarios = new ArrayList<>();
        for(Usuario usuario: usuarios) {
            mUsuarios.add(new MUsuario(usuario));
        }
        return mUsuarios;
    }
}
