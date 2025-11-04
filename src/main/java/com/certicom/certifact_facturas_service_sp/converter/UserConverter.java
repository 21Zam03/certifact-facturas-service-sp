package com.certicom.certifact_facturas_service_sp.converter;

import com.certicom.certifact_facturas_service_sp.dto.others.UserDto;
import com.certicom.certifact_facturas_service_sp.model.UserModel;

public class UserConverter {

    public static UserDto modelToDto(UserModel userModel) {
        return UserDto.builder()
                .idUser(userModel.getIdUser())
                .idOficina(userModel.getOficinaId())
                .nombreUsuario(userModel.getDeLogin())
                .contrasena(userModel.getPassword())
                .nombreCompleto(userModel.getFullName())
                .dni(userModel.getDni())
                .estado(userModel.getEstado())
                .activo(userModel.getEnabled())
                .build();
    }

}
