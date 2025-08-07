package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.model.UsuarioInterDto;
import com.certicom.certifact_facturas_service_sp.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data/user")
@RequiredArgsConstructor
@Slf4j
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Long idUsuario) {
        log.info("UserController - obtenerUsuario - [idUsuario={}]", idUsuario);
        UsuarioInterDto usuario = usuarioService.obtenerUsuario(idUsuario);
        log.info("UserController - obtenerUsuario - [usuario={}]", usuario.toString());
        return  new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
