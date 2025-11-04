package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.others.UserDto;

public interface UsuarioService {

    UserDto findUserById(Long idUsuario);

    UserDto findUserByUsername(String username);
    String findUsernameById(Long idUsuario);

}
