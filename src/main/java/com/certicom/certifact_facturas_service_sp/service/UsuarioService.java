package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.model.UsuarioInterDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface UsuarioService {

    UsuarioInterDto obtenerUsuario(Long idUsuario);
    UsuarioInterDto findUserByUsername(String username);

}
