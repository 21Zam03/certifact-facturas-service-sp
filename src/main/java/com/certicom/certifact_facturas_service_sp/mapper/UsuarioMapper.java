package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.model.UsuarioInterDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface UsuarioMapper {

    UsuarioInterDto obtenerUsuarioPorId(@PathVariable("idUsuario") Long idUsuario);

}
