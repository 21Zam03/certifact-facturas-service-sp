package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.others.UserDto;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        UserDto usuario = usuarioService.findUserById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/byUsername")
    public ResponseEntity<?> getByUsername(@RequestParam String username) {
        UserDto usuario = usuarioService.findUserByUsername(username);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/{id}/username")
    public ResponseEntity<?> getUsernameById(@PathVariable Long id) {
        String username = usuarioService.findUsernameById(id);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

}
