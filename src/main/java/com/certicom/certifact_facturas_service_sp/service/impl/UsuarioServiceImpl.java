package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.model.User;
import com.certicom.certifact_facturas_service_sp.exceptions.ExcepcionNegocio;
import com.certicom.certifact_facturas_service_sp.mapper.UserMapper;
import com.certicom.certifact_facturas_service_sp.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    private final UserMapper userMapper;

    @Override
    public User findUserById(Long idUsuario) {
        //log.info("UsuarioServiceImpl - obtenerUsuario - [idUsuario= {}]", idUsuario);
        User usuario = null;
        if (idUsuario != null) {
            try {
                usuario =  userMapper.findUserById(idUsuario);
            } catch (Exception e) {
                log.error("ERROR: {}", e.getMessage());
            }
        } else {
            throw new ExcepcionNegocio("idUsuario is null");
        }
        //log.info("UsuarioServiceImpl - usuario={}", usuario == null ? "null" : usuario.toString());
        return usuario;
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

}
