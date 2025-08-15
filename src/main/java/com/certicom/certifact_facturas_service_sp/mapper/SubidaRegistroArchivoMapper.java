package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.dto.model.SubidaRegistroArchivoDto;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubidaRegistroArchivoMapper {

    int registrarSubidaArchivo(SubidaRegistroArchivoDto subidaRegistroArchivoDto);


}
