package com.me.Java.controllers;

import com.me.Java.dao.UsuarioDao;
import com.me.Java.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value ="api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Perez");
        usuario.setEmail("lucas@gmail.com");
        usuario.setTelefono("123456789");
        return usuario;
    }

    @RequestMapping(value ="api/usuarios")
    public List<Usuario> getAll(){

        return usuarioDao.getUsuarios();
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

    @RequestMapping(value ="api/usuarios", method = RequestMethod.POST)
    public void saveUsuario(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value ="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }
}
