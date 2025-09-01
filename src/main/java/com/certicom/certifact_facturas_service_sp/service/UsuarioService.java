package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.model.User;

public interface UsuarioService {

    User findUserById(Long idUsuario);
    User findUserByUsername(String username);

}
