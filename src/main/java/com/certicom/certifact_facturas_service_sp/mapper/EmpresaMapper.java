package com.certicom.certifact_facturas_service_sp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmpresaMapper {

    String obtenerEstadoEmpresaPorRuc(@Param("ruc") String rucEmisor);

}
