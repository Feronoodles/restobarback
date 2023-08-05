package com.example.demo.model.usuario;

import com.example.demo.entity.TipoUsuario;
import com.example.demo.entity.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public record MUsuarioVista(
        Long usuarioId,
        String correo,
        int activo,
        String tokenCelular,
        TipoUsuario tipoUsuario
) {
    public MUsuarioVista(Usuario usuario)
    {
        this(usuario.getid(), usuario.getCorreo(), usuario.getActivo(), usuario.getTokenCelular(),usuario.getTipoUsuario());
    }

}
