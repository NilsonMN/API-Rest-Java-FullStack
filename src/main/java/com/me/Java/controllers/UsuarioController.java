package com.me.Java.controllers;

import com.me.Java.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value ="usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Perez");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;
    }

    @RequestMapping(value ="usuarios")
    public List<Usuario> getAll(){

        List<Usuario> usuarios = new ArrayList<Usuario>();

        Usuario usuario = new Usuario();
        usuario.setId(123L);
        usuario.setNombre("Lucas");
        usuario.setApellido("Perez");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456789");

        Usuario usuario2 = new Usuario();
        usuario2.setId(456L);
        usuario2.setNombre("Lucas");
        usuario2.setApellido("Perez");
        usuario2.setEmail("lucas@gmail.com");
        usuario2.setTelefono("123456789");

        usuarios.add(usuario);
        usuarios.add(usuario2);

        return usuarios;
    }

    @RequestMapping(value ="asd")
    public Usuario update(){

        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Perez");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;
    }

    @RequestMapping(value ="qwe")
    public Usuario save(){

        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Perez");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;
    }

    @RequestMapping(value ="zxc")
    public Usuario delete(){

        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Perez");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;
    }
}
