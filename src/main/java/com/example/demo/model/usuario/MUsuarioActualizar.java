package com.example.demo.model.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public record MUsuarioActualizar(
        @NotNull
        Long usuarioId,
        @Email
        String correo,
        String contraseña,
        int activo,
        String token,
        String tokenCelular


) {
}
