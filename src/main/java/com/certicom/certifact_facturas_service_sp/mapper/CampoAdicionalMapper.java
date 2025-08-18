package com.certicom.certifact_facturas_service_sp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface CampoAdicionalMapper {

    Long obtenerCampoAdicionalIdPorNombre(@RequestParam String nombreCampo);

}
