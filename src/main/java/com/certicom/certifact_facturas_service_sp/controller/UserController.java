package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.model.User;
import com.certicom.certifact_facturas_service_sp.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserController.API_PATH)
@RequiredArgsConstructor
public class UserController {

    public static final String API_PATH = "/api/user";
    private final UsuarioService usuarioService;

    @GetMapping("/idUser")
    public ResponseEntity<?> findUserById(@RequestParam Long idUser) {
        //log.info("UserController - obtenerUsuario - [idUsuario={}]", idUsuario);
        User usuario = usuarioService.findUserById(idUser);
        //log.info("UserController - obtenerUsuario - [usuario={}]", usuario.toString());
        return  new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/username")
    public ResponseEntity<?> findUserByUsername(@RequestParam String username) {
        User usuario = usuarioService.findUserByUsername(username);
        return  new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
