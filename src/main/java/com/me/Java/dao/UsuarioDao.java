package com.me.Java.dao;

import com.me.Java.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();
    void eliminar(Long id);
    void registrar(Usuario usuario);

    boolean verificarEmailPassword(Usuario usuario);
}
