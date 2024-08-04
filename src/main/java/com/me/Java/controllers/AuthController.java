package com.me.Java.controllers;

import com.me.Java.dao.UsuarioDao;
import com.me.Java.models.Usuario;
import com.me.Java.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String registrarUsuario(@RequestBody Usuario usuario) {

        Usuario usuarioLogeado = usuarioDao.verificarEmailPassword(usuario);

        if(usuarioLogeado != null) {
            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLogeado.getId()),
                    usuarioLogeado.getEmail());
            return tokenJWT;
        }
        return "FAILW";
    }
}
