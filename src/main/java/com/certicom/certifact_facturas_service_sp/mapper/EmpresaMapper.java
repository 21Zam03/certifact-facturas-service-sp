package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.model.EmpresaDto;
import com.certicom.certifact_facturas_service_sp.dto.model.OseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface EmpresaMapper {

    String obtenerEstadoEmpresaPorRuc(@Param("ruc") String rucEmisor);
    EmpresaDto obtenerEmpresaPorRuc(@Param("ruc") String ruc);
    public OseDto findOseByRucInter(@Param("ruc") String ruc);

}
